import org.junit.*;
import static org.junit.Assert.*;

/** Programme de test JUnit pour les ensembles.
 *  @author	Xavier Crégut &lt;prenom.nom@enseeiht.fr&gt;
  */
abstract public class EnsembleTestAbstrait<E> {

	protected Ensemble<E> e1;

	private E[] tab0;	// pour faire les tests élémentaires

	private E[] tab1; 	// contient des données qui ne sont pas dans
						// l'ensemble pour faire les tests

	@Before
	public void setUp() throws Exception {
		tab0 = this.creerDonneesDeTest();
		tab1 = this.creerDonneesInexistantes();
		this.e1 = nouvelEnsemble(10);
		// System.out.println("e1 = " + e1);
	}

	abstract protected Ensemble<E> nouvelEnsemble(int capacite);
		// la capacité sera utile dans le cas d'un ensemble tableau pour
		// choisir la capacité initiale du tableau utilisé pour stocker
		// les éléments.

	/** Créer un tableau de données de test sans doublons.
	 * @return un tableau d'éléments (au moins 3) de type E
	 */
	abstract protected E[] creerDonneesDeTest();

	/**
     * Créer un tableau de données qui ne sont PAS dans l'ensemble de test initial.
     * @return un tableau d'éléments de type E
     */
    abstract protected E[] creerDonneesInexistantes();


	/** On rend le helper générique. */
	// Pour résoudre l'avertissement :
	@SafeVarargs // Pour indiquer au compilateur qu'il n'y a pas de risque
	// de pollution de tas (Heap Pollution)
	static <T> void ajouterTous(Ensemble<T> ens, T... elements) {
		for (T n : elements) {
			ens.ajouter(n);
		}
	}

	@Test
	public void testInitVide() {
		assertNotNull(e1);
		assertTrue(e1.estVide());
		assertEquals(0, e1.cardinal());
	}

	@Test
	public void testAjouterPremier() {
		assertTrue(e1.estVide());
		e1.ajouter(tab0[0]);
		assertFalse(e1.estVide());
		assertEquals(1, e1.cardinal());
		assertTrue(e1.contient(tab0[0]));
	}

	@Test
	public void testAjouterPlusieursFois() {
		assertTrue(e1.estVide());
		e1.ajouter(tab0[0]);
		e1.ajouter(tab0[0]);
		e1.ajouter(tab0[0]);
		e1.ajouter(tab0[0]);
		assertFalse(e1.estVide());
		assertEquals(1, e1.cardinal());
		assertTrue(e1.contient(tab0[0]));
	}

	@Test
	public void testAjouterTroisElements() {
		e1.ajouter(tab0[0]);
		e1.ajouter(tab0[1]);
		e1.ajouter(tab0[2]);
		assertEquals(3, e1.cardinal());
		assertTrue(e1.contient(tab0[0]));
		assertTrue(e1.contient(tab0[2]));
		assertTrue(e1.contient(tab0[1]));
	}

	@Test
	public void testContient() {
		e1.ajouter(tab0[0]);
		e1.ajouter(tab0[1]);
		e1.ajouter(tab0[2]);
		assertEquals(3, e1.cardinal());
		assertTrue(e1.contient(tab0[0]));
		assertTrue(e1.contient(tab0[2]));
		assertTrue(e1.contient(tab0[1]));
		for (E element : tab1) {
			assertFalse(e1.contient(element));
		}
	}

	@Test
	public void testSupprimerAbsent() {
		ajouterTous(e1, tab0);
		E elementAbsent = tab1[0]; // Cet élément n'est pas dans l'ensemble
		assertFalse(e1.contient(elementAbsent));
		assertEquals(tab0.length, e1.cardinal());
		e1.supprimer(elementAbsent);
		assertFalse(e1.contient(elementAbsent));
		assertEquals(tab0.length, e1.cardinal());
		e1.supprimer(elementAbsent);
		e1.supprimer(elementAbsent);
		for (E element : tab0) {
			assertTrue(e1.contient(element));
		}
		assertFalse(e1.contient(elementAbsent));
		assertEquals(tab0.length, e1.cardinal());
	}

	@Test
	public void testSupprimerPresent() {
		ajouterTous(e1, tab0);
		E elementPresent = tab0[0];
		assertEquals(tab0.length, e1.cardinal());
		assertTrue(e1.contient(elementPresent));
		e1.supprimer(elementPresent);
		assertFalse(e1.contient(elementPresent));
		assertEquals(tab0.length - 1, e1.cardinal());
	}

	@Test
	public void testSupprimerDifferentsCas() {
		ajouterTous(e1, tab0);
		for (int i = 0; i < tab0.length; i++) {
			e1.supprimer(tab0[i]);
			assertFalse(e1.contient(tab0[i]));
			assertEquals(tab0.length - 1 - i, e1.cardinal());
		}
		assertEquals(0, e1.cardinal());
		assertTrue(e1.estVide());
	}

	/*@
	  	requires tab.length > 0;
		requires // éléments tous différents
		(\forall int i1; i1 >= 0 && i1 < tab.length;
			(\forall int i2; i2 >= 0 && i2 < i1;
			tab[i1] != tab[i2]));
	@*/
	// Pour résoudre l'avertissement (Heap Pollution) :
	@SafeVarargs // la méthode doit ếtre soit static soit final
	protected final void testerAvecTab(E... tab) {

		// Au fur et à mesure que l'on ajoute les éléments, on vérifie la
		// présence des éléments.
		for (int i = 0; i < tab.length; i++) {
			e1.ajouter(tab[i]);
			assertEquals(i+1, e1.cardinal());
			// vérifier la présence des éléments insérés
			for (int j = 0; j <= i; j++) {
				assertTrue(e1.contient(tab[j]));
			}
			// vérifier l'absence des éléments à insérer
			for (int j = i+1; j < tab.length; j++) {
				assertFalse(e1.contient(tab[j]));
			}
		}
	}

	@Test
	public void testerAvecTab1() {
		testerAvecTab(tab0);
	}

	@Test
	public void testerAvecTab2() {
		testerAvecTab(tab1);
	}

}
