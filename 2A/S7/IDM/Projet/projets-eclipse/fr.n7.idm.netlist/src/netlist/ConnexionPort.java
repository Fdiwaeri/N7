/**
 */
package netlist;

import fr.n7.idm.catalogue.Port;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connexion Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link netlist.ConnexionPort#getPort <em>Port</em>}</li>
 *   <li>{@link netlist.ConnexionPort#getInstance <em>Instance</em>}</li>
 * </ul>
 *
 * @see netlist.NetlistPackage#getConnexionPort()
 * @model
 * @generated
 */
public interface ConnexionPort extends EObject {
	/**
	 * Returns the value of the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' reference.
	 * @see #setPort(Port)
	 * @see netlist.NetlistPackage#getConnexionPort_Port()
	 * @model required="true"
	 * @generated
	 */
	Port getPort();

	/**
	 * Sets the value of the '{@link netlist.ConnexionPort#getPort <em>Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' reference.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(Port value);

	/**
	 * Returns the value of the '<em><b>Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance</em>' reference.
	 * @see #setInstance(InstanceComposant)
	 * @see netlist.NetlistPackage#getConnexionPort_Instance()
	 * @model required="true"
	 * @generated
	 */
	InstanceComposant getInstance();

	/**
	 * Sets the value of the '{@link netlist.ConnexionPort#getInstance <em>Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance</em>' reference.
	 * @see #getInstance()
	 * @generated
	 */
	void setInstance(InstanceComposant value);

} // ConnexionPort
