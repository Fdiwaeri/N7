/**
 */
package netlist.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import netlist.ConnexionPort;
import netlist.NetlistFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Connexion Port</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConnexionPortTest extends TestCase {

	/**
	 * The fixture for this Connexion Port test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnexionPort fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ConnexionPortTest.class);
	}

	/**
	 * Constructs a new Connexion Port test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnexionPortTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Connexion Port test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ConnexionPort fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Connexion Port test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnexionPort getFixture() {
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
		setFixture(NetlistFactory.eINSTANCE.createConnexionPort());
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

} //ConnexionPortTest
