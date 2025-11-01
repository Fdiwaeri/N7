/** EnsembleChaine est une réalisation de Ensemble qui
 * utilise une structure chaînée pour stocker ses éléments.
 * 
 * @author F.E
 */

public class EnsembleChaine implements Ensemble {
    /** La première cellule de l'ensemble. */
    protected Cellule premiere;

    /** Le nombre d'éléments de l'ensemble. */
    protected int cardinal = 0;

    /** Construire un ensemble chainee vide. */
    public EnsembleChaine() {
        this.premiere = null;
    }

    /** Obtenir le nombre d'éléments dans l'ensemble.
	 * @return nombre d'éléments dans l'ensemble.  */
	public int cardinal() {
        return this.cardinal;
    }

	/** Savoir si l'ensemble est vide.
	 * @return Est-ce que l'ensemble est vide ? */
	public boolean estVide() {
        return (this.cardinal==0);
    }

	/** Savoir si un élément est présent dans l'ensemble.
	 * @param x l'élément cherché
	 * @return x est dans l'ensemble */
	public boolean contient(int x) {
        if (this.cardinal == 0) {
            return false;
        } else {
            return this.premiere.contientChainee(x);
        }
    }

	/** Ajouter un élément dans l'ensemble.
	 * @param x l'élément à ajouter */
	//@ ensures contient(x);        // élément ajouté
	public void ajouter(int x) {
        if (!this.contient(x)) {
            this.premiere = new Cellule(x, this.premiere);
            this.cardinal++;
        }
    }

	/** Enlever un élément de l'ensemble.
	  * @param x l'élément à supprimer */
	//@ ensures ! contient(x);      // élément supprimé
	public void supprimer(int x) {
        if (this.premiere.contientChainee(x)) {
            this.cardinal--;
            if (premiere.getValeur()==x) {
                premiere = premiere.getSuivant();
                return;
            }
            Cellule temp = premiere;
            while (temp.getSuivant().getValeur() != x) {
                temp = temp.getSuivant();
            }
            Cellule cellule = temp.getSuivant().getSuivant();
            temp.setSuivant(cellule);
        }
    }

}