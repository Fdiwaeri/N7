package layout.export;

import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.emf.ecore.util.EcoreUtil;

import layout.Board;
import layout.ComposantPosition;
import layout.Couche;
import layout.CoucheExterne;
import layout.Layout;
import layout.Piste;
import layout.Point;

/**
 * Exporteur SVG pour les layouts
 */
public class SVGExporter {
    
    private static final double SCALE = 10.0; // 1mm = 10 pixels
    private static final String[] COLORS = {
        "#FF6B6B", "#4ECDC4", "#45B7D1", "#FFA07A", "#98D8C8"
    };
    
    /**
     * Exporte un layout complet (toutes les couches de toutes les boards)
     * IMPORTANT: Résout tous les proxies avant l'export
     */
    public static void exportLayout(Layout layout, String outputFolder) throws IOException {
        EcoreUtil.resolveAll(layout.eResource().getResourceSet());
        
        for (Board board : layout.getBoards()) {
            exportBoard(board, outputFolder);
        }
    }
    
    /**
     * Exporte une board (toutes ses couches)
     */
    public static void exportBoard(Board board, String outputFolder) throws IOException {
        int coucheIndex = 0;
        for (Couche couche : board.getCouches()) {
            String filename = outputFolder + "/" + 
                sanitizeFilename(board.getNom()) + "_" + 
                sanitizeFilename(couche.getNom()) + ".svg";
            exportCouche(board, couche, filename, coucheIndex++);
        }
    }
    
    /**
     * Exporte une couche en SVG
     */
    public static void exportCouche(Board board, Couche couche, String filename, int colorIndex) 
            throws IOException {
        
        StringBuilder svg = new StringBuilder();
        
        // En-tête SVG
        double width = board.getLargeur() * SCALE;
        double height = board.getHauteur() * SCALE;
        
        svg.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        svg.append("<svg xmlns=\"http://www.w3.org/2000/svg\" ");
        svg.append("width=\"").append(width).append("\" ");
        svg.append("height=\"").append(height).append("\" ");
        svg.append("viewBox=\"0 0 ").append(width).append(" ").append(height).append("\">\n");
        
        // Titre
        svg.append("  <title>").append(board.getNom()).append(" - ").append(couche.getNom()).append("</title>\n");
        
        // Fond blanc
        svg.append("  <rect width=\"100%\" height=\"100%\" fill=\"white\"/>\n");
        
        // Grille
        svg.append("  <!-- Grille -->\n");
        svg.append("  <defs>\n");
        svg.append("    <pattern id=\"grid\" width=\"").append(10 * SCALE).append("\" height=\"").append(10 * SCALE).append("\" patternUnits=\"userSpaceOnUse\">\n");
        svg.append("      <path d=\"M ").append(10 * SCALE).append(" 0 L 0 0 0 ").append(10 * SCALE).append("\" fill=\"none\" stroke=\"#e0e0e0\" stroke-width=\"0.5\"/>\n");
        svg.append("    </pattern>\n");
        svg.append("  </defs>\n");
        svg.append("  <rect width=\"100%\" height=\"100%\" fill=\"url(#grid)\"/>\n");
        
        // Contour de la board
        svg.append("  <rect x=\"0\" y=\"0\" ");
        svg.append("width=\"").append(width).append("\" ");
        svg.append("height=\"").append(height).append("\" ");
        svg.append("fill=\"none\" stroke=\"black\" stroke-width=\"3\"/>\n");
        
        // Composants (si couche externe)
        if (couche instanceof CoucheExterne) {
            CoucheExterne coucheExt = (CoucheExterne) couche;
            svg.append("\n  <!-- Composants -->\n");
            
            for (ComposantPosition cp : coucheExt.getComposants()) {
                svg.append(generateComposantSVG(cp, colorIndex));
            }
        }
        
        // Pistes
        svg.append("\n  <!-- Pistes -->\n");
        String pisteColor = COLORS[colorIndex % COLORS.length];
        
        for (Piste piste : couche.getPistes()) {
            svg.append(generatePisteSVG(piste, pisteColor));
        }
        
        // Légende
        svg.append("\n  <!-- Légende -->\n");
        svg.append("  <text x=\"10\" y=\"").append(height - 10).append("\" ");
        svg.append("font-family=\"Arial\" font-size=\"12\" fill=\"black\">");
        svg.append(board.getNom()).append(" - ").append(couche.getNom());
        svg.append("</text>\n");
        
        svg.append("</svg>");
        
        // Écrire le fichier
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(svg.toString());
        }
        
        System.out.println(" Exporté: " + filename);
    }
    
    /**
     * Génère le SVG pour un composant
     */
    private static String generateComposantSVG(ComposantPosition cp, int colorIndex) {
        // Debug amélioré
        boolean isProxy = cp.getInstance() != null && cp.getInstance().eIsProxy();
        System.out.println("Composant: " + 
            (cp.getInstance() != null ? cp.getInstance().getNom() : "null") + 
            ", proxy = " + isProxy);
        
        if (cp.getInstance() == null || 
            cp.getInstance().eIsProxy() ||  
            cp.getInstance().getDefinition() == null || 
            cp.getInstance().getDefinition().getEmpreinte() == null) {
            
            if (cp.getInstance() != null && cp.getInstance().eIsProxy()) {
                System.err.println("ERREUR: Proxy non résolu pour le composant!");
            }
            return "";
        }
        
        StringBuilder svg = new StringBuilder();
        
        double x = cp.getX() * SCALE;
        double y = cp.getY() * SCALE;
        double w = cp.getInstance().getDefinition().getEmpreinte().getLargeur() * SCALE;
        double h = cp.getInstance().getDefinition().getEmpreinte().getHauteur() * SCALE;
        
        String color = COLORS[(colorIndex + 2) % COLORS.length];
        
        // Rectangle du composant
        svg.append("  <g id=\"").append(cp.getInstance().getId()).append("\">\n");
        double x0 = x - w / 2;
        double y0 = y - h / 2;

        svg.append("    <rect x=\"").append(x0).append("\" y=\"").append(y0).append("\" ");
        svg.append("width=\"").append(w).append("\" height=\"").append(h).append("\" ");
        svg.append("fill=\"").append(color).append("\" fill-opacity=\"0.7\" ");
        svg.append("stroke=\"#333\" stroke-width=\"2\"/>\n");
        
        // Label
        svg.append("    <text x=\"").append(x + w/2).append("\" y=\"").append(y + h/2).append("\" ");
        svg.append("font-family=\"Arial\" font-size=\"10\" text-anchor=\"middle\" ");
        svg.append("dominant-baseline=\"middle\" fill=\"black\">");
        svg.append(cp.getInstance().getNom());
        svg.append("</text>\n");
        svg.append("  </g>\n");
        return svg.toString();
    }
    
    /**
     * Génère le SVG pour une piste
     */
    private static String generatePisteSVG(Piste piste, String color) {
        if (piste.getPoints().size() < 2) {
            return "";
        }
        
        StringBuilder svg = new StringBuilder();
        
        // Ligne polyline
        svg.append("  <polyline points=\"");
        
        for (Point p : piste.getPoints()) {
            svg.append(p.getX() * SCALE).append(",").append(p.getY() * SCALE).append(" ");
        }
        
        svg.append("\" fill=\"none\" stroke=\"").append(color).append("\" ");
        svg.append("stroke-width=\"").append(piste.getLargeur() * SCALE).append("\" ");
        svg.append("stroke-linecap=\"round\" stroke-linejoin=\"round\"/>\n");
        
        // Label de la piste
        if (piste.getNom() != null && !piste.getNom().isEmpty()) {
            Point midPoint = piste.getPoints().get(piste.getPoints().size() / 2);
            svg.append("  <text x=\"").append(midPoint.getX() * SCALE).append("\" ");
            svg.append("y=\"").append(midPoint.getY() * SCALE).append("\" ");
            svg.append("font-family=\"Arial\" font-size=\"8\" fill=\"").append(color).append("\">");
            svg.append(piste.getNom());
            svg.append("</text>\n");
        }
        
        return svg.toString();
    }
    
    /**
     * Nettoie un nom de fichier
     */
    private static String sanitizeFilename(String name) {
        if (name == null) {
            return "unnamed";
        }
        return name.replaceAll("[^a-zA-Z0-9_-]", "_");
    }
    
    /**
     * Exemple d'utilisation
     */
    public static void main(String[] args) throws Exception {
        Layout layout = TestsUtils.loadLayout();
        SVGExporter.exportLayout(layout, "export-svg");
    }
}