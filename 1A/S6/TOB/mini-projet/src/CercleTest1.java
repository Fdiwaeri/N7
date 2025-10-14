import org.junit.*;
import static org.junit.Assert.*;
import java.awt.Color;

/** Programme de test de la classe Cercle.
  * @author  Fadwa
  */
public class CercleTest {

	public static final double EPSILON = 1e-6;
		// précision pour la comparaison entre réels.

    // Les points du sujet
	private Point p1;
	private Point p2;

	@Before
	public void setUp() {
		// Construire les points
		p1 = new Point(4, 1);
		p2 = new Point(8, 1);
	}

	@Test
	public void testCercle1() {                                  //test E12
		Cercle C = new Cercle(p1, p2);
		assertNotNull(C);
		assertEquals(C.getCentre().getX(), (p1.getX() + p2.getX())/2, EPSILON);
		assertEquals(C.getCentre().getY(), (p1.getY() + p2.getY())/2, EPSILON);
		assertEquals(C.getRayon(), p1.distance(p2)/2, EPSILON);
	}

	@Test
	public void testCercle2() {                                 //test E13
		Cercle C = new Cercle(p1, p2, Color.red);
		assertNotNull(C);
		assertEquals(C.getCentre().getX(), (p1.getX() + p2.getX())/2, EPSILON);
		assertEquals(C.getCentre().getY(), (p1.getY() + p2.getY())/2, EPSILON);
		assertEquals(C.getRayon(), p1.distance(p2)/2, EPSILON);
		assertTrue(C.getCouleur() == Color.red);
	}

	@Test
	public void testCreerCercle() {                             //test E14
		Cercle C = Cercle.creerCercle(p1, p2);
		assertNotNull(C);
		assertEquals(C.getCentre().getX(), p1.getX(), EPSILON);
		assertEquals(C.getCentre().getY(), p1.getY(), EPSILON);
		assertEquals(C.getRayon(), p1.distance(p2), EPSILON);
	}
}
