/**
 * Classe de test pour EnsembleChaine<Integer>.
 */
public class EnsembleChaineTest extends EnsembleTestAbstrait<Integer> {

	protected Ensemble<Integer> nouvelEnsemble(int capacite) {
		return new EnsembleChaine<Integer>();
	}

	protected Integer[] creerDonneesDeTest() {
		return new Integer[] {10, 15, -5};
	}

	 protected Integer[] creerDonneesInexistantes() {
		return new Integer[] {1, 100, 2, 0};
	 }

}
