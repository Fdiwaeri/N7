import afficheur.Ecran;

/**
 * Construire le schéma en utilisant la classe Groupe pour structurer les objets.
 *
 * @author F.E
 */
public class ExempleSchemaGroupe {

    public static void main(String[] args) {
        // Créer les points et segments initiaux
        Point p1 = new PointNomme(3, 2, "A");
        Point p2 = new PointNomme(6, 9, "S");
        Point p3 = new Point(11, 4);
        Segment s12 = new Segment(p1, p2);
        Segment s23 = new Segment(p2, p3);
        Segment s31 = new Segment(p3, p1);

        // Créer le barycentre
        double sx = p1.getX() + p2.getX() + p3.getX();
        double sy = p1.getY() + p2.getY() + p3.getY();
        Point barycentre = new PointNomme(sx / 3, sy / 3, "C");

        // Créer un groupe pour les 3 segments du triangle
        Groupe groupeSegments = new Groupe();
        groupeSegments.ajouter(s12);
        groupeSegments.ajouter(s23);
        groupeSegments.ajouter(s31);

        // Créer le schéma principal qui contient le groupe de segments et le barycentre
        Groupe schema = new Groupe();
        schema.ajouter(groupeSegments);
        schema.ajouter(barycentre);

        // Afficher le schéma
        System.out.println("Le schéma est composé de : ");
        schema.afficher();
        System.out.println();

        // Créer l'écran d'affichage
        Ecran ecran = new Ecran("ExempleSchemaGroupe", 600, 400, 20);
        ecran.dessinerAxes();

        // Dessiner le schéma sur l'écran graphique
        schema.dessiner(ecran);

        // Translater tout le schéma en une seule instruction
        System.out.println("Translater le schéma de (4, -3) : ");
        schema.translater(4, -3);

        // Afficher le schéma après translation
        System.out.println("Le schéma translaté est composé de : ");
        schema.afficher();
        System.out.println();

        // Dessiner le schéma translaté
        schema.dessiner(ecran);

        // Forcer l'affichage
        ecran.rafraichir();
    }
}