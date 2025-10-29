import afficheur.Afficheur;
import java.awt.Color;

/** AfficheurTexte permet de dessiner un schéma sous une forme textuelle
 * qui permet de facilement comprendre la nature des objets du schéma
 * et leurs caractéristiques.
 * Il s'agit d'une réalisation de l'interface Afficheur du paquetage 
 * afficheur.
 * 
 * @author F.E
 */
public class AfficheurTexte implements Afficheur {

    /** Créer un afficher texte. */
    public AfficheurTexte(){
    }

    /** Afficher un point.
     * @param x abscisse du point
     * @param y ordonnée du point
     * @param c couleur du point
     */
    public void dessinerPoint(double x, double y, Color c){
        System.out.println("Point {");
        System.out.println("        x = " + x);
        System.out.println("        y = " + y);
        System.out.println("        couleur = " + c);
        System.out.println("}");
    }

    /** Afficher un segment entre deux points.
     * @param x1 abscisse du premier point
     * @param y1 ordonnée du premier point
     * @param x2 abscisse du deuxième point
     * @param y2 ordonnée du deuxème point
     * @param c couleur du point
     */
    public void dessinerLigne(double x1, double y1, double x2, double y2, Color c){
        System.out.println("Ligne {");
        System.out.println("        x1 = " + x1);
        System.out.println("        y1 = " + y1);
        System.out.println("        x2 = " + x2);
        System.out.println("        y2 = " + y2);
        System.out.println("        couleur = " + c);
        System.out.println("}");
    }

    /** Afficher un cercle.
     * @param x abscisse du centre du cercle
     * @param y ordonnée du centre du cercle
     * @param rayon rayon du cercle
     * @param c couleur du cercle
     */
    public void dessinerCercle(double x, double y, double rayon, Color c){
        System.out.println("Cercle {");
        System.out.println("        centre_x = " + x);
        System.out.println("        centre_y = " + y);
        System.out.println("        rayon = " + rayon);
        System.out.println("        couleur = " + c);
        System.out.println("}");
    }

    /** Afficher un cercle.
     * @param x abscisse du centre du cercle
     * @param y ordonnée du centre du cercle
     * @param c couleur du cercle
     */
    public void dessinerTexte(double x, double y, java.lang.String texte, Color c){
        System.out.println("Texte {");
        System.out.println("        x = " + x);
        System.out.println("        y = " + y);
        System.out.println("        valeur = " + texte);
        System.out.println("        couleur = " + c);
        System.out.println("}");
    }
}