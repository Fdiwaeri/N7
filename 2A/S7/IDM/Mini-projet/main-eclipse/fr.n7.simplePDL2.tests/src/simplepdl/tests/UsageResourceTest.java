/**
 */
package simplepdl.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import simplepdl.SimplepdlFactory;
import simplepdl.UsageResource;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Usage Resource</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class UsageResourceTest extends TestCase {

	/**
	 * The fixture for this Usage Resource test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UsageResource fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(UsageResourceTest.class);
	}

	/**
	 * Constructs a new Usage Resource test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsageResourceTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Usage Resource test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(UsageResource fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Usage Resource test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UsageResource getFixture() {
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
		setFixture(SimplepdlFactory.eINSTANCE.createUsageResource());
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

} //UsageResourceTest
