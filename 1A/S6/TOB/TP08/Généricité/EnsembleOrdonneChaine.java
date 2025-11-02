import java.util.NoSuchElementException;

/** Ensemble Ordonne Chaine est un ensemble qui utilise
 * la structure chaînée de EnsembleChaine et la propriété
 * de l'ordre de EnsembleOrdonne.
 * 
 * @author F.E
 */

public class EnsembleOrdonneChaine<E extends Comparable<E>> extends EnsembleChaine<E> implements EnsembleOrdonne<E> {

    /** Obtenir le plus petit élément d'un ensemble.
     * @return le plus petit élément
     * @throws java.util.NoSuchElementException s'il n'y a pas de min
     */
    @Override
    public E min() {
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
	public void ajouter(E x) {
        if (!this.contient(x)) {
            if (this.estVide() || x.compareTo(this.min())<0) {
                Cellule<E> temp = new Cellule<E>(x, this.premiere);
                this.premiere = temp;
            } else {
                Cellule<E> temp = this.premiere;
                while (x.compareTo(temp.getSuivant().getValeur())>0 && temp.getSuivant()!=null){
                    temp = temp.getSuivant();
                }
                Cellule<E> cellule = new Cellule<E>(x, temp.getSuivant());
                temp.setSuivant(cellule);
            }
            this.cardinal++;
        }
    }

    /** Obtenir le plus petit élément strictement plus grand que
     * x passé en paramètre.
     * @param x un élement de type E
     * @return le plus petit élément de l'ensemble > x
     */
    public E justePlusGrandQue(E x) {
        if (this.estVide()) { return null;}
        Cellule<E> temp = premiere;
        while (x.compareTo(temp.getValeur())>=0) {
            temp = temp.getSuivant();
            if (temp == null) {return null;}
        }
        return temp.getValeur();
    }

    /** Afficher le valeurs d'un EnsembleOrdonneChaine. 
     * Non demandée dans le sujet! Juste pour visualisation.
    */
    public void afficher() {
        System.out.println("Cet EnsembleOrdonneChaine contient "+ this.cardinal()  +" éléments :");
        Cellule<E> temp = this.premiere.getSuivant();
        System.out.print(this.premiere.getValeur());
        while (temp!=null) {
            System.out.println(",");
            System.out.print(temp.getValeur());
            temp = temp.getSuivant();
        }
        System.out.println(".");
    }

}