/** Construire un schéma composé de 4 éléments:
  * 3 segements construits à partir de 3 points
  * et le barycentre de ces 3 points.
  * @author Fadwa
  */
public class ExempleSchema1 {
    
    /** Afficher le nom d'un point et ses cooredonées 
      * @param nom le nom du point
      * @param p le point à afficher
    */
    public static void afficherPN (String nom, Point p){
        System.out.print(nom + " = ");
        p.afficher();
        System.out.println();
    }

    /** Afficher le nom d'un segment et ses coordonées
      * @param nom le nom du segment
      * @param s le segment à afficher
    */
    public static void afficherSN (String nom, Segment s){
        System.out.print(nom + " = ");
        s.afficher();
        System.out.println();
    }

    /** Méthode principale */
    public static void main (String[] args) {
        // Construire les 3 points
        Point p1 = new Point(3, 2);
        Point p2 = new Point(6, 9);
        Point p3 = new Point(11, 4);

        // Afficher les points construits
        afficherPN("p1", p1);
        afficherPN("p2", p2);
        afficherPN("p3", p3);
        
        // Construire les 3 segments
        Segment s12 = new Segment(p1, p2);
        Segment s23 = new Segment(p2, p3);
        Segment s31 = new Segment(p3, p1);
        
        // Afficher les segments construits
        afficherSN("s12", s12);
        afficherSN("s23", s23);
        afficherSN("s31", s31);

        // Construire le barycentre des 3 points
        //  = centre de gravité du triangle construit par les 3 segments
        double bX = (p1.getX() + p2.getX() + p3.getX())/3;
        double bY = (p1.getY() + p2.getY() + p3.getY())/3;
        Point b = new Point(bX, bY);
        
        // Afficher le barycentre
        afficherPN("barycentre des 3 points", b);
    }
}
