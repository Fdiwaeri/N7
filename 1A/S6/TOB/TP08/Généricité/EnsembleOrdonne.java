/** Un Ensemble Ordonné est un ensemble dont les éléments
 * sont équipés d'une relation d'ordre.
 * 
 * @author F.E
 */

// Tout type E qu'on doit être capable d'utiliser dans cette classe
// doit posséder la possiblité d'être comparé à d'autres objets de 
// son type.
public interface EnsembleOrdonne<E extends Comparable<E>> extends Ensemble<E> {

    /** Obtenir le plus petit élément d'un ensemble.
     * @return le plus petit élément
     * @throws java.util.NoSuchElementException s'il n'y a pas de min
     */
    E min();

    /** Obtenir le plus petit élément strictement plus grand que
     * x passé en paramètre.
     * @param x un élement de type E
     * @return le plus petit élément de l'ensemble > x
     */
    E justePlusGrandQue(E x);
    // Cette méthode existe déjà dans l'API Java.
    // Nom de la méthode : higher(E e)
    // Elle est définie dans l'interface java.util.NavigableSet. La classe TreeSet l'implémente.
}