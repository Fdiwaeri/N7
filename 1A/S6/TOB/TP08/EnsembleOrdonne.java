/** Un Ensemble Ordonné est un ensemble dont les éléments
 * sont équipés d'une relation d'ordre.
 * 
 * @author F.E
 */

public interface EnsembleOrdonne extends Ensemble {

    /** Obtenir le plus petit élément d'un ensemble.
     * @return le plus petit élément
     * @throws java.util.NoSuchElementException s'il n'y a pas de min
     */
    int min();
}