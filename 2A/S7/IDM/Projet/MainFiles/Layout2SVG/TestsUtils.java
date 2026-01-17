package layout.export;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import fr.n7.idm.catalogue.CataloguePackage;
import netlist.NetlistPackage;
import layout.Layout;
import layout.LayoutPackage;

public class TestsUtils {
    
    
    public static Layout loadLayout() throws Exception {
        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResourceFactoryRegistry()
            .getExtensionToFactoryMap()
            .put("xmi", new XMIResourceFactoryImpl());
        resourceSet.getPackageRegistry().put(CataloguePackage.eNS_URI, CataloguePackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(NetlistPackage.eNS_URI, NetlistPackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(LayoutPackage.eNS_URI, LayoutPackage.eINSTANCE);
        

        File workspaceRoot = new File(".").getAbsoluteFile();
        URI workspaceURI = URI.createFileURI(workspaceRoot.getAbsolutePath() + "/");
        
        resourceSet.getURIConverter().getURIMap().put(
            URI.createPlatformResourceURI("/fr.n7.idm.layout/", true),
            workspaceURI
        );

        resourceSet.getURIConverter().getURIMap().put(
            URI.createPlatformResourceURI("/fr.n7.idm.catalogue/", true),
            workspaceURI
        );
        
        resourceSet.getURIConverter().getURIMap().put(
            URI.createPlatformResourceURI("/fr.n7.idm.netlist/", true),
            workspaceURI
        );
        
        System.out.println("=== CHARGEMENT DES MODÈLES ===");
        System.out.println("Workspace: " + workspaceURI);
        

        URI catalogueURI = URI.createFileURI("./passives.xmi");
        Resource catalogueResource = resourceSet.getResource(catalogueURI, true);
        System.out.println("Catalogue chargé: " + catalogueURI);
        

        URI netlistURI = URI.createFileURI("./filter.xmi");
        Resource netlistResource = resourceSet.getResource(netlistURI, true);
        System.out.println("Netlist chargé: " + netlistURI);
        

        URI layoutURI = URI.createFileURI("./board.xmi");
        Resource layoutResource = resourceSet.getResource(layoutURI, true);
        System.out.println("Layout chargé: " + layoutURI);
        

        System.out.println("\n Résolution des proxies...");
        EcoreUtil.resolveAll(resourceSet);

        boolean hasUnresolvedProxies = false;
        for (Resource resource : resourceSet.getResources()) {
            if (!resource.getErrors().isEmpty()) {
                System.err.println(" Erreurs dans " + resource.getURI() + ":");
                for (org.eclipse.emf.ecore.resource.Resource.Diagnostic error : resource.getErrors()) {
                    System.err.println("  - " + error.getMessage());
                }
                hasUnresolvedProxies = true;
            }
        }
        
        if (!hasUnresolvedProxies) {
            System.out.println(" Tous les proxies sont résolus!");
        } else {
            System.err.println(" ATTENTION: Des proxies n'ont pas pu être résolus");
        }
        
        System.out.println("==============================\n");

        Layout layout = (Layout) layoutResource.getContents().get(0);
        return layout;
    }
    

    public static Layout loadLayoutAbsolute(String baseDir) throws Exception {
        ResourceSet resourceSet = new ResourceSetImpl();
        
        resourceSet.getResourceFactoryRegistry()
            .getExtensionToFactoryMap()
            .put("xmi", new XMIResourceFactoryImpl());
        
        resourceSet.getPackageRegistry().put(CataloguePackage.eNS_URI, CataloguePackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(NetlistPackage.eNS_URI, NetlistPackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(LayoutPackage.eNS_URI, LayoutPackage.eINSTANCE);

        File workspace = new File(baseDir).getAbsoluteFile();
        URI workspaceURI = URI.createFileURI(workspace.getAbsolutePath() + "/");
        
        resourceSet.getURIConverter().getURIMap().put(
            URI.createPlatformResourceURI("/fr.n7.idm.layout/", true),
            workspaceURI
        );

        URI catalogueURI = URI.createFileURI(baseDir + "/passives.xmi");
        URI netlistURI = URI.createFileURI(baseDir + "/filter.xmi");
        URI layoutURI = URI.createFileURI(baseDir + "/board.xmi");
        
        resourceSet.getResource(catalogueURI, true);
        resourceSet.getResource(netlistURI, true);
        Resource layoutResource = resourceSet.getResource(layoutURI, true);
        
        EcoreUtil.resolveAll(resourceSet);
        
        return (Layout) layoutResource.getContents().get(0);
    }
    
    /**
     * Test de diagnostic des proxies
     */
    public static void diagnoseProxies(Layout layout) {
        System.out.println("\n=== DIAGNOSTIC DES PROXIES ===");
        
        layout.getBoards().forEach(board -> {
            System.out.println("\nBoard: " + board.getNom());
            
            board.getCouches().forEach(couche -> {
                System.out.println("  Couche: " + couche.getNom());
                
                if (couche instanceof layout.CoucheExterne) {
                    layout.CoucheExterne coucheExt = (layout.CoucheExterne) couche;
                    
                    coucheExt.getComposants().forEach(cp -> {
                        boolean isProxy = cp.getInstance() == null || cp.getInstance().eIsProxy();
                        String status = isProxy ? " PROXY" : " OK";
                        String nom = cp.getInstance() != null ? cp.getInstance().getNom() : "null";
                        
                        System.out.println("    Composant: " + nom + " - " + status);
                        
                        if (!isProxy && cp.getInstance().getDefinition() != null) {
                            boolean defIsProxy = cp.getInstance().getDefinition().eIsProxy();
                            System.out.println("      Définition: " + 
                                (defIsProxy ? " PROXY" : " OK"));
                        }
                    });
                }
            });
        });
        
        System.out.println("===============================\n");
    }
    
   
    public static void mapPlatformURIs(ResourceSet resourceSet, String workspaceDir) {
        File workspace = new File(workspaceDir).getAbsoluteFile();
        URI workspaceURI = URI.createFileURI(workspace.getAbsolutePath() + "/");

        String[] projects = {
            "fr.n7.idm.layout",
            "fr.n7.idm.netlist", 
            "fr.n7.idm.catalogue"
        };
        
        for (String project : projects) {
            resourceSet.getURIConverter().getURIMap().put(
                URI.createPlatformResourceURI("/" + project + "/", true),
                workspaceURI
            );
        }
        
        System.out.println(" URIs platform mappées vers: " + workspaceURI);
    }
}