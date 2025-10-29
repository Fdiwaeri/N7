import afficheur.Ecran;
import afficheur.AfficheurSVG;

/** Construire le schéma proposé dans le sujet de TP avec des points,
  * et des segments.
  *
  * @author	Xavier Crégut
  * @version	$Revision: 1.7 $
  */
public class ExempleSchema1 {

	/** Construire le schéma et le manipuler.
	  * Le schéma est affiché.
	  * @param args les arguments de la ligne de commande
	  */
	public static void main(String[] args)
	{
		// Créer les trois segments
		Point p1 = new Point(3, 2);
		Point p2 = new Point(6, 9);
		Point p3 = new Point(11, 4);
		Segment s12 = new Segment(p1, p2);
		Segment s23 = new Segment(p2, p3);
		Segment s31 = new Segment(p3, p1);

		// Créer le barycentre
		double sx = p1.getX() + p2.getX() + p3.getX();
		double sy = p1.getY() + p2.getY() + p3.getY();
		Point barycentre = new Point(sx / 3, sy / 3);

		// Afficher le schéma
		System.out.println("Le schéma est composé de : ");
		s12.afficher();		System.out.println();
		s23.afficher();		System.out.println();
		s31.afficher();		System.out.println();
		barycentre.afficher();	System.out.println();

		// Dessiner le schéma sur un écran
		Ecran schema = new Ecran("ExempleSchéma1", 600, 400, 20);
		schema.dessinerAxes();
		s12.dessiner(schema);
		s23.dessiner(schema);
		s31.dessiner(schema);
		barycentre.dessiner(schema);

		// Dessiner le schéma par un afficheur SVG
		AfficheurSVG monSVG = new AfficheurSVG("Exemple schema SVG", "SVG", 300, 200);
		s12.dessinerSVG(monSVG);
		s23.dessinerSVG(monSVG);
		s31.dessinerSVG(monSVG);
		barycentre.dessinerSVG(monSVG);

		// Translater le schéma de 4 suivant X et -3 suivant Y
		s12.translater(4, -3);
		s23.translater(4, -3);
		s31.translater(4, -3);
		barycentre.translater(4, -3);

		// Afficher et dessiner le schéma à nouveau
		System.out.println("Le schéma après translation (4, -3) est composé de : ");
		s12.afficher();		System.out.println();
		s23.afficher();		System.out.println();
		s31.afficher();		System.out.println();
		barycentre.afficher();	System.out.println();
		// sur l'écran
		s12.dessiner(schema);
		s23.dessiner(schema);
		s31.dessiner(schema);
		barycentre.dessiner(schema);
		// en SVG
		s12.dessinerSVG(monSVG);
		s23.dessinerSVG(monSVG);
		s31.dessinerSVG(monSVG);
		barycentre.dessinerSVG(monSVG);

		// Afficher le schema SVG
		monSVG.ecrire(); // sur la sortie standard
		monSVG.ecrire("schema.svg"); // sur le fichier schema.svg

		// Dessiner le schéma par un afficheur texte
		AfficheurTexte schemaTxt = new AfficheurTexte();
		s12.dessinerTexte(schemaTxt);
		s23.dessinerTexte(schemaTxt);
		s31.dessinerTexte(schemaTxt);
		barycentre.dessinerTexte(schemaTxt);

		// Dessiner un cercle rouge de centre (1, 1) et rayon 2
		schemaTxt.dessinerCercle(1, 1, 2, java.awt.Color.red);
		// Dessiner un texte "Exemple Schéma" en bleu à (0, 0)
		schemaTxt.dessinerTexte(0, 0, "Exemple Schéma", java.awt.Color.blue);

	}

}
