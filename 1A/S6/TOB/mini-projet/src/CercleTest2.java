import java.awt.Color;
import org.junit.*;
import static org.junit.Assert.*;

/**
  * Classe de test de la classe Cercle.
  * @author	Fadwa
  */
public class CercleTest {

	// précision pour les comparaisons réelle
	public final static double EPSILON = 0.001;

	// Les points du sujet
	private Point C, D, E;

	// Les cercles du sujet
	private Cercle C2, C3;

	@Before public void setUp() {
		// Construire les points
		C = new Point(4, 1);
		D = new Point(8, 1);
		E = new Point(8, 4);

		// Construire les cercles
		C2 = new Cercle(C, D);
        Cercle C3;
	}

	/** Vérifier si deux points ont mêmes coordonnées.
	  * @param p1 le premier point
	  * @param p2 le deuxième point
	  */
	static void memesCoordonnees(String message, Point p1, Point p2) {
		assertEquals(message + " (x)", p1.getX(), p2.getX(), EPSILON);
		assertEquals(message + " (y)", p1.getY(), p2.getY(), EPSILON);
	}

	@Test public void testerE12C2() {
		memesCoordonnees("E12 : Centre de C2 incorrect", new Point(6, 1), C2.getCentre());
		assertEquals("E12 : Rayon de C2 incorrect",
				2, C2.getRayon(), EPSILON);
		assertEquals(Color.blue, C2.getCouleur());
	}

	@Test public void testerE13() {
		C2 = new Cercle(C, D, Color.yellow);
        memesCoordonnees("E13 : Centre de C2 incorrect", new Point(6, 1), C2.getCentre());
		assertEquals("E12 : Rayon de C2 incorrect",
				2, C2.getRayon(), EPSILON);
		assertEquals(Color.yellow, C2.getCouleur());
	}

	@Test public void testerE14C3() {
        C3 = Cercle.creerCercle(D, E);
		memesCoordonnees("E14 : Centre de C3 incorrect", D, C3.getCentre());
		assertEquals("E14 : Rayon de C3 incorrect",
				3, C3.getRayon(), EPSILON);
		assertEquals(Color.blue, C3.getCouleur());
	}
}
