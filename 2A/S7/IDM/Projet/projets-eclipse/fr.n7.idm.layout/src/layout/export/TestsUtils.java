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
    
    /**
     * Charge un layout avec résolution des références croisées
     * MÉTHODE CORRECTE pour charger plusieurs modèles interdépendants
     */
    public static Layout loadLayout() throws Exception {
        // 1. Créer UN SEUL ResourceSet pour TOUS les modèles
        ResourceSet resourceSet = new ResourceSetImpl();
        
        // 2. Enregistrer les factories
        resourceSet.getResourceFactoryRegistry()
            .getExtensionToFactoryMap()
            .put("xmi", new XMIResourceFactoryImpl());
        
        // 3. Enregistrer les packages
        resourceSet.getPackageRegistry().put(CataloguePackage.eNS_URI, CataloguePackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(NetlistPackage.eNS_URI, NetlistPackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(LayoutPackage.eNS_URI, LayoutPackage.eINSTANCE);
        
        //  4. Mapper les URIs platform:/resource/ vers file://
        // Cela permet de résoudre les références qui utilisent des URIs Eclipse
        File workspaceRoot = new File(".").getAbsoluteFile();
        URI workspaceURI = URI.createFileURI(workspaceRoot.getAbsolutePath() + "/");
        
        resourceSet.getURIConverter().getURIMap().put(
            URI.createPlatformResourceURI("/fr.n7.idm.layout/", true),
            workspaceURI
        );
        
        // Vous pouvez ajouter d'autres mappings si nécessaire
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
        
        // 5. Charger TOUS les modèles dans le MÊME ResourceSet
        // L'ordre peut être important : charger les dépendances d'abord
        
        // Catalogue (dépendance de netlist)
        URI catalogueURI = URI.createFileURI("./passives.xmi");
        Resource catalogueResource = resourceSet.getResource(catalogueURI, true);
        System.out.println("Catalogue chargé: " + catalogueURI);
        
        // Netlist (dépendance de layout)
        URI netlistURI = URI.createFileURI("./filter.xmi");
        Resource netlistResource = resourceSet.getResource(netlistURI, true);
        System.out.println("Netlist chargé: " + netlistURI);
        
        // Layout (dépend de netlist et catalogue)
        URI layoutURI = URI.createFileURI("./board.xmi");
        Resource layoutResource = resourceSet.getResource(layoutURI, true);
        System.out.println("Layout chargé: " + layoutURI);
        
        // 6. ⭐ CRITIQUE: Résoudre TOUS les proxies
        System.out.println("\n Résolution des proxies...");
        EcoreUtil.resolveAll(resourceSet);
        
        // 7. Vérifier qu'il n'y a plus de proxies non résolus
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
        
        // 8. Retourner le layout
        Layout layout = (Layout) layoutResource.getContents().get(0);
        return layout;
    }
    
    /**
     * Méthode alternative : chargement avec chemins absolus
     */
    public static Layout loadLayoutAbsolute(String baseDir) throws Exception {
        ResourceSet resourceSet = new ResourceSetImpl();
        
        resourceSet.getResourceFactoryRegistry()
            .getExtensionToFactoryMap()
            .put("xmi", new XMIResourceFactoryImpl());
        
        resourceSet.getPackageRegistry().put(CataloguePackage.eNS_URI, CataloguePackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(NetlistPackage.eNS_URI, NetlistPackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(LayoutPackage.eNS_URI, LayoutPackage.eINSTANCE);
        
        // Mapper les URIs platform
        File workspace = new File(baseDir).getAbsoluteFile();
        URI workspaceURI = URI.createFileURI(workspace.getAbsolutePath() + "/");
        
        resourceSet.getURIConverter().getURIMap().put(
            URI.createPlatformResourceURI("/fr.n7.idm.layout/", true),
            workspaceURI
        );
        
        // Utiliser des URIs absolus
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
    
    /**
     * Méthode utilitaire pour mapper automatiquement tous les projets d'un workspace
     */
    public static void mapPlatformURIs(ResourceSet resourceSet, String workspaceDir) {
        File workspace = new File(workspaceDir).getAbsoluteFile();
        URI workspaceURI = URI.createFileURI(workspace.getAbsolutePath() + "/");
        
        // Liste des projets Eclipse à mapper (ajoutez les vôtres si nécessaire)
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