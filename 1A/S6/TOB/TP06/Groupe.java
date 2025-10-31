import java.util.ArrayList;

/** Groupe sert à grouper plusieurs X (objets géométriques)
 * pour les manipuler comme un seul et leur appliquer à tous,
 * en une seule fois, le même opération (translater, afficher,
 * etc)
 * 
 * @author F.E
 */

public class Groupe extends X {
    /** Un groupe contient une liste d'éléments X. */
    private ArrayList<X> objets;

    /** Construire un groupe vide. */
    public Groupe() {
        this.objets = new ArrayList<>();
    }

    /** Ajouter un objet géométrique à un groupe.
     * @param objet l'objet à ajouter
     */
    public void ajouter(X objet) {
        this.objets.add(objet);
    }

    /** Translater les éléments d'un groupe.
     *  Translater un objet géométrique.
     * @param dx déplacement suivant l'axe des X
	 * @param dy déplacement suivant l'axe des Y
	 */
    @Override
	public void translater(double dx, double dy) {
        objets.forEach(objet -> {
            objet.translater(dx, dy);
        });
    }

    /** Afficher les élements d'un groupe. */
    @Override
    public void afficher() {
        System.out.println("Groupe {");
        objets.forEach(objet -> {
            objet.afficher();
            System.out.println();
        });
        System.out.print("}");
    }

    /** Dessiner les éléments d'un groupe.
     * @param afficheur l'afficheur à utiliser
     */
    @Override
    public void dessiner(afficheur.Afficheur afficheur) {
        objets.forEach(objet -> {
            objet.dessiner(afficheur);
        });
    }

}