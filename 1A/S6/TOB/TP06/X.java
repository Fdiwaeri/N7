import java.awt.Color;

/** X représente tous les objets, ou plus précisèment les formes
 * géometriques (points, points nommés, segments, cercles, etc)
 * qu'on peut avoir dans un schéma.
 * 
 * @author F.E
 */

abstract public class X {

    //@ private invariant getCouleur() != null;
	//@ private invariant getCouleur() == couleur;	// invariant de liaison
    /** Tout objet géométrique possède une couleur. */
    private Color couleur;

//  Gestion de la couleur

    /** Construire un objet X en initialisant sa couleur. */
    public X() {
        this.couleur = Color.green;
    }

    /** Construire un objet X en initialisant sa couleur avec celle donnée.
     * @param vcouleur la couleur de X
     */
    public X(Color vcouleur) {
        this.couleur = vcouleur;
    }

    /** Obtenir la couleur de X.
	 * @return la couleur de X
	 */
	public Color getCouleur() {
		return this.couleur;
	}

	/** Changer la couleur de X.
	 * @param nouvelleCouleur nouvelle couleur
	 */
	public void setCouleur(Color nouvelleCouleur) {
		this.couleur = nouvelleCouleur;
	}

    /** Afficher un objet géométrique. */
    abstract void afficher();

    /** Translater un objet géométrique.
     * @param dx déplacement suivant l'axe des X
	 * @param dy déplacement suivant l'axe des Y
	 */
	abstract void translater(double dx, double dy);

    /** Dessiner l'objet géométrique.
     * @param afficheur l'afficheur à utiliser
     */
    abstract void dessiner(afficheur.Afficheur afficheur);
}