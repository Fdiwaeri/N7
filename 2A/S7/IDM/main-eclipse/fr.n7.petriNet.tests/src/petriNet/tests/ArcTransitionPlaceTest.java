/**
 */
package petriNet.tests;

import junit.textui.TestRunner;

import petriNet.ArcTransitionPlace;
import petriNet.PetriNetFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Arc Transition Place</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ArcTransitionPlaceTest extends ArcTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ArcTransitionPlaceTest.class);
	}

	/**
	 * Constructs a new Arc Transition Place test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArcTransitionPlaceTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Arc Transition Place test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ArcTransitionPlace getFixture() {
		return (ArcTransitionPlace)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(PetriNetFactory.eINSTANCE.createArcTransitionPlace());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ArcTransitionPlaceTest
