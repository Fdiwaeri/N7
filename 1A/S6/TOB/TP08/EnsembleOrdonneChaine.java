import java.util.NoSuchElementException;

/** Ensemble Ordonne Chaine est un ensemble qui utilise
 * la structure chaînée de EnsembleChaine et la propriété
 * de l'ordre de EnsembleOrdonne.
 * 
 * @author F.E
 */

public class EnsembleOrdonneChaine extends EnsembleChaine implements EnsembleOrdonne {

    /** Obtenir le plus petit élément d'un ensemble.
     * @return le plus petit élément
     * @throws java.util.NoSuchElementException s'il n'y a pas de min
     */
    @Override
    public int min() {
        if (this.estVide()) {
            // L'ensemble est vide, donc il n'y a pas de min
            throw new NoSuchElementException("L'ensemble est vide.");
        }
        // L'ensemble est ordonné, donc le plus petit
        // est le premier.
        return premiere.getValeur();
    }

    /** Ajouter un élément dans l'ensemble.
	 * @param x l'élément à ajouter */
	//@ ensures contient(x);        // élément ajouté
    @Override
	public void ajouter(int x) {
        if (!this.contient(x)) {
            if (this.estVide() || x<this.min()) {
                Cellule temp = new Cellule(x, this.premiere);
                this.premiere = temp;
            } else {
                Cellule temp = this.premiere;
                while (x>temp.getSuivant().getValeur() && temp.getSuivant()!=null){
                    temp = temp.getSuivant();
                }
                Cellule cellule = new Cellule(x, temp.getSuivant());
                temp.setSuivant(cellule);
            }
            this.cardinal++;
        }
    }

    /** Afficher le valeurs d'un EnsembleOrdonneChaine. */
    public void afficher() {
        System.out.println("Cet EnsembleOrdonneChaine contient "+ this.cardinal()  +" éléments :");
        Cellule temp = this.premiere.getSuivant();
        System.out.print(this.premiere.getValeur());
        while (temp!=null) {
            System.out.println(",");
            System.out.print(temp.getValeur());
            temp = temp.getSuivant();
        }
        System.out.println(".");
    }

}