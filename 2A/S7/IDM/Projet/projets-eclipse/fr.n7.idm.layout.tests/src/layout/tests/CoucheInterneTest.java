/**
 */
package layout.tests;

import junit.textui.TestRunner;

import layout.CoucheInterne;
import layout.LayoutFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Couche Interne</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CoucheInterneTest extends CoucheTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CoucheInterneTest.class);
	}

	/**
	 * Constructs a new Couche Interne test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoucheInterneTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Couche Interne test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected CoucheInterne getFixture() {
		return (CoucheInterne)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(LayoutFactory.eINSTANCE.createCoucheInterne());
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

} //CoucheInterneTest
