/**
 */
package layout.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import layout.LayoutFactory;
import layout.Piste;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Piste</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PisteTest extends TestCase {

	/**
	 * The fixture for this Piste test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Piste fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PisteTest.class);
	}

	/**
	 * Constructs a new Piste test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PisteTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Piste test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Piste fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Piste test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Piste getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(LayoutFactory.eINSTANCE.createPiste());
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

} //PisteTest
