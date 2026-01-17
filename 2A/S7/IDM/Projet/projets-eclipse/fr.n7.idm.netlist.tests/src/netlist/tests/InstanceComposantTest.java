/**
 */
package netlist.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import netlist.InstanceComposant;
import netlist.NetlistFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Instance Composant</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class InstanceComposantTest extends TestCase {

	/**
	 * The fixture for this Instance Composant test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceComposant fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(InstanceComposantTest.class);
	}

	/**
	 * Constructs a new Instance Composant test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceComposantTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Instance Composant test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(InstanceComposant fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Instance Composant test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceComposant getFixture() {
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
		setFixture(NetlistFactory.eINSTANCE.createInstanceComposant());
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

} //InstanceComposantTest
