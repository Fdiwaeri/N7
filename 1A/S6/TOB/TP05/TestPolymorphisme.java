/** Tester le polymorphisme (principe de substitution) et la liaison
 * dynamique.
 * @author	Xavier Crégut
 * @version	1.5
 */
public class TestPolymorphisme {

	/** Méthode principale */
	public static void main(String[] args) {
		// Créer et afficher un point p1
		Point p1 = new Point(3, 4);	// Est-ce autorisé ? Pourquoi ? -> C'est autorisé, car la variable et l'objet sont de meme type Point
		p1.translater(10,10);		// Quel est le translater exécuté ? -> translater de la classe Point
		System.out.print("p1 = "); p1.afficher (); System.out.println ();
										// Qu'est ce qui est affiché ? -> p1 = (13.0, 14.0)

		// Créer et afficher un point nommé pn1
		PointNomme pn1 = new PointNomme (30, 40, "PN1");
										// Est-ce autorisé ? Pourquoi ? -> C'est autorisé, car la variable et l'objet sont de meme type PointNomme
		pn1.translater (10,10);		// Quel est le translater exécuté ? -> translater de PointNomme
		System.out.print ("pn1 = "); pn1.afficher(); System.out.println ();
										// Qu'est ce qui est affiché ? -> pn1 = PN1:(40.0, 50.0)

		// Définir une poignée sur un point
		Point q;

		// Attacher un point à q et l'afficher
		q = p1;				// Est-ce autorisé ? Pourquoi ? -> C'est autorisé, car q et p1 sont de meme type Point
		System.out.println ("> q = p1;");
		System.out.print ("q = "); q.afficher(); System.out.println ();
										// Qu'est ce qui est affiché ? -> q = (13.0, 14.0)

		// Attacher un point nommé à q et l'afficher
		q = pn1;			// Est-ce autorisé ? Pourquoi ? -> C'est autorisé, car le type PointNomme de pn1 hérite du type Point de q 
		System.out.println ("> q = pn1;");
		System.out.print ("q = "); q.afficher(); System.out.println ();
										// Qu'est ce qui est affiché ? -> q = PN1:(40.0, 50.0)

		// Définir une poignée sur un point nommé
		PointNomme qn;

		// Attacher un point à q et l'afficher
		//qn = p1;			// Est-ce autorisé ? Pourquoi ? -> Non, car la variable qn de type PointNomme (classe fille) ne peut pas contenir p1 de type Point (classe mère)
		//System.out.println ("> qn = p1;");
		//System.out.print ("qn = "); qn.afficher(); System.out.println ();
										// Qu'est ce qui est affiché ? -> l'affectation n'est pas autorisée

		// Attacher un point nommé à qn et l'afficher
		qn = pn1;			// Est-ce autorisé ? Pourquoi ? -> C'est autorisée, ils sont de meme type PointNomme
		System.out.println ("> qn = pn1;");
		System.out.print ("qn = "); qn.afficher(); System.out.println ();
										// Qu'est ce qui est affiché ? -> qn = PN1:(40.0, 50.0)

		double d1 = p1.distance (pn1);	// Est-ce autorisé ? Pourquoi ? -> PointNomme est un Point (pn1)
		System.out.println ("distance = " + d1);

		double d2 = pn1.distance (p1);	// Est-ce autorisé ? Pourquoi ? -> PointNomme est un Point (pn1)
		System.out.println ("distance = " + d2);

		double d3 = pn1.distance (pn1);	// Est-ce autorisé ? Pourquoi ? -> PointNomme est un Point (pn1)
		System.out.println ("distance = " + d3);

		//System.out.println ("> qn = q;");
		//qn = q;				// Est-ce autorisé ? Pourquoi ? -> Non, car la variable qn de type PointNomme (classe fille) ne peut pas contenir q déclarée Point (classe mère) meme si son contenu est un PointNomme
		//System.out.print ("qn = "); qn.afficher(); System.out.println ();
										// Qu'est ce qui est affiché ? -> l'affectation n'est pas autorisée

		System.out.println ("> qn = (PointNomme) q;");
		qn = (PointNomme) q;		// Est-ce autorisé ? Pourquoi ? -> Oui, car la variable q (Point) fair référence à un objet de type PointNomme
		System.out.print ("qn = "); qn.afficher(); System.out.println ();

		System.out.println ("> qn = (PointNomme) p1;");
		qn = (PointNomme) p1;		// Est-ce autorisé ? Pourquoi ? -> Non, car le contenu de p1 (déclarée Point) est un objet de type Point
		System.out.print ("qn = "); qn.afficher(); System.out.println ();
	}

}
