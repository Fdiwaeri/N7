/**
 */
package layout.tests;

import junit.textui.TestRunner;

import layout.CoucheExterne;
import layout.LayoutFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Couche Externe</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CoucheExterneTest extends CoucheTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CoucheExterneTest.class);
	}

	/**
	 * Constructs a new Couche Externe test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoucheExterneTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Couche Externe test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected CoucheExterne getFixture() {
		return (CoucheExterne)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(LayoutFactory.eINSTANCE.createCoucheExterne());
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

} //CoucheExterneTest
