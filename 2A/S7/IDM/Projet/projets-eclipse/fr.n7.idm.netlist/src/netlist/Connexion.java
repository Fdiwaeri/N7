/**
 */
package netlist;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connexion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link netlist.Connexion#getNom <em>Nom</em>}</li>
 *   <li>{@link netlist.Connexion#getConnextionsPort <em>Connextions Port</em>}</li>
 * </ul>
 *
 * @see netlist.NetlistPackage#getConnexion()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='directionValide'"
 * @generated
 */
public interface Connexion extends EObject {
	/**
	 * Returns the value of the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nom</em>' attribute.
	 * @see #setNom(String)
	 * @see netlist.NetlistPackage#getConnexion_Nom()
	 * @model
	 * @generated
	 */
	String getNom();

	/**
	 * Sets the value of the '{@link netlist.Connexion#getNom <em>Nom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nom</em>' attribute.
	 * @see #getNom()
	 * @generated
	 */
	void setNom(String value);

	/**
	 * Returns the value of the '<em><b>Connextions Port</b></em>' containment reference list.
	 * The list contents are of type {@link netlist.ConnexionPort}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connextions Port</em>' containment reference list.
	 * @see netlist.NetlistPackage#getConnexion_ConnextionsPort()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<ConnexionPort> getConnextionsPort();

} // Connexion
