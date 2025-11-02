import java.util.Objects; // On utilisera Objects.equals()
// pour comparer des objets qui peuvent être null.

/** Cellule possède une valeur et une référence à la cellule
 * qui la suit.
 * 
 * @author F.E
 */
public class Cellule<E> {

    /** La valeur contenue par la cellule. */
    private E valeur;
    /** La cellule suivante. */
    private Cellule<E> suivant;

    /** Construire une cellule. 
     * @param valeur la valeur de la cellule
     * @param suivant la cellule suivante
    */
    public Cellule (E valeur, Cellule<E> suivant){
        this.valeur = valeur;
        this.suivant = suivant;
    }

    /** Obtenir la valeur d'une cellule.
     * @return la valeur de la cellule
     */
    public E getValeur(){
        return this.valeur;
    }

    /** Changer la valeur d'un cellule.
     * @param valeur la nouvelle valeur
     */
    public void setValeur(E valeur) {
        this.valeur = valeur;
    }

    /** Obtenir la cellule suivante d'une cellule.
     * @return la cellule suivante
     */
    public Cellule<E> getSuivant() {
        return this.suivant;
    }

    /** Changer la cellule suivante.
     * @param vcellule la nouvelle cellule suivante
    */
    public void setSuivant(Cellule<E> vcellule) {
        this.suivant = vcellule;
    }

    /** Savoir si un élément est présent dans les cellules enchainées.
	 * @param x l'élément cherché
	 * @return x est dans l'enchainement des cellules */
    public boolean contientChainee(E x) {
        if (Objects.equals(this.valeur, x)) {
            return true;
        } else {
            if (this.suivant == null) { return false; }
            else {
                return this.suivant.contientChainee(x);
            }
        }
    }

}