/** X représente tous les objets, ou plus précisèment les formes
 * géometriques (points, points nommés, segments, cercles, etc)
 * qu'on peut avoir dans un schéma.
 * 
 * @author F.E
 */

public interface X {

    /** Afficher un objet géométrique. */
    void afficher();

    /** Translater un objet géométrique.
     * @param dx déplacement suivant l'axe des X
	 * @param dy déplacement suivant l'axe des Y
	 */
	void translater(double dx, double dy);

    /** Dessiner l'objet géométrique.
     * @param afficheur l'afficheur à utiliser
     */
    void dessiner(afficheur.Afficheur afficheur);
}