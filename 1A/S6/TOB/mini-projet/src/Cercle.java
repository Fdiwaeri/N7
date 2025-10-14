import java.awt.Color;

/** Un cercle est une courbe plane fermée constituée des points situés à égale
 * distance d’un point nommé centre. La valeur de cette distance est appelée
 * rayon du cercle.
 * On appelle diamètre la distance entre deux points diamétralement opposés.
 * La valeur du diamètre est donc le double de la valeur du rayon.
 *
 * @author  Fadwa
 */
public class Cercle implements Mesurable2D {
    // C12: définir la constante PI
    /**
     * La constante PI qui représente la valeur de pi et qui est utilisée pour
     * les calculs circulaires.
     */
    public static final double PI = Math.PI;
	/** le centre du cercle. */
	private Point c;
	/** le rayon du cercle. */
	private double r;
	/** la couleur du cercle. */
	private Color couleur;

	/** Construire un cercle à partir de son centre et de son rayon.
	 * @param c1 centre
	 * @param vr rayon
	 */
	public Cercle(Point c1, double vr) {                            //E11
		this.c = new Point(c1.getX(), c1.getY());
		this.r = vr;
		this.couleur = Color.blue;
	}

	/** Construire un cercle à partir de deux points diamétralement opposés.
	 * @param p1 point1
	 * @param p2 point2
	 */
	public Cercle(Point p1, Point p2) {                             //E12
		this.c = new Point((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2);
		this.r = p1.distance(p2) / 2;
		this.couleur = Color.blue;
	}

	/** Construire un cercle à partir de deux points diamétralement opposés et
	 * de sa couleur.
	 * @param p1 point1
	 * @param p2 point2
	 * @param vcouleur couleur
	 */
	public Cercle(Point p1, Point p2, Color vcouleur) {              //E13
		this.c = new Point((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2);
		this.r = p1.distance(p2) / 2;
		this.couleur = vcouleur;
	}


	/** Créer un cercle à partir de deux points, le premier correspond au centre
	 * du cercle et le deuxième est un point du cercle (de sa circonférence).
	 * @param c1 centre du cercle
	 * @param p1 point du cercle
	 * @return cercle de centre c1
	 */
	public static Cercle creerCercle(Point c1, Point p1) {          //E14
		Cercle cercle = new Cercle(new Point(c1.getX(), c1.getY()), c1.distance(p1));
		return cercle;
	}

	/** Obtenir le centre du cercle.
	 * @return centre du cercle
	 */
	public Point getCentre() {                                      //E2
		return new Point(this.c.getX(), this.c.getY());
	}

	/** Obtenir le rayon du cercle.
	 * @return rayon du cercle
	 */
	public double getRayon() {                                      //E3
		return this.r;
	}

	/** Obtenir le diamètre du cercle.
	 * @return diamètre du cercle
	 */
	public double getDiametre() {                                   //E4
		return 2 * this.r;
	}

	/** Obtenir la couleur du cercle.
	 * @return couleur du cercle
	 */
	public Color getCouleur() {                                     //E9
		return this.couleur;
	}

	/** Changer le rayon du cercle.
	  * @param vr nouuveau rayon
	  */
	public void setRayon(double vr) {                               //E16
		this.r = vr;
	}

	/** Changer le diamètre du cercle.
	  * @param vd nouveau diamètre
	  */
	public void setDiametre(double vd) {                            //E17
		this.r = vd / 2;
	}

	/** Changer la couleur du cercle.
	  * @param couleur nouvelle couleur
	  */
	public void setCouleur(Color couleur) {                         //E10
		this.couleur = couleur;
	}

	/** Savoir si un point est à l'intérieur d'un cercle ou non.
	  * @param p1 point
	  * @return True si le point est l'intérieur, False sinon
	  */
    public boolean contient(Point p1) {                             //E5
        return p1.distance(this.c) <= this.r;
    }

    /** Obtenir le périmètre du cercle.
	 * @return périmètre du cercle
	 */
	public double perimetre() {                                     //E6
		return 2 * this.r * PI;
	}

	/** Obtenir l'aire du cercle.
	 * @return aire du cercle
	 */
	public double aire() {                                          //E6
		return PI*Math.pow(this.r, 2);
	}

    /** Transformer le cercle en format textuelle (String).
      * @return cercle sous la forme "Cr@(a, b)"
      */
	public String toString() {
		return "C" + this.r + "@" + this.c.toString();
	}

	/** Afficher le cercle. */
	public void afficher() {                                        //E15
		System.out.print(this);
	}

   /** Translater le cercle.
	* @param dx déplacement suivant l'axe des X
	* @param dy déplacement suivant l'axe des Y
	*/
	public void translater(double dx, double dy) {                  //E1
		this.c.translater(dx, dy);
	}
}
