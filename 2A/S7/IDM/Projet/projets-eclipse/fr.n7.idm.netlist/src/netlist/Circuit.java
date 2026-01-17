/**
 */
package netlist;

import fr.n7.idm.catalogue.Catalogue;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Circuit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link netlist.Circuit#getNom <em>Nom</em>}</li>
 *   <li>{@link netlist.Circuit#getDescription <em>Description</em>}</li>
 *   <li>{@link netlist.Circuit#getCatalogue <em>Catalogue</em>}</li>
 *   <li>{@link netlist.Circuit#getInstances <em>Instances</em>}</li>
 *   <li>{@link netlist.Circuit#getConnexions <em>Connexions</em>}</li>
 *   <li>{@link netlist.Circuit#getCommentaires <em>Commentaires</em>}</li>
 * </ul>
 *
 * @see netlist.NetlistPackage#getCircuit()
 * @model
 * @generated
 */
public interface Circuit extends EObject {
	/**
	 * Returns the value of the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nom</em>' attribute.
	 * @see #setNom(String)
	 * @see netlist.NetlistPackage#getCircuit_Nom()
	 * @model
	 * @generated
	 */
	String getNom();

	/**
	 * Sets the value of the '{@link netlist.Circuit#getNom <em>Nom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nom</em>' attribute.
	 * @see #getNom()
	 * @generated
	 */
	void setNom(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see netlist.NetlistPackage#getCircuit_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link netlist.Circuit#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Catalogue</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Catalogue</em>' reference.
	 * @see #setCatalogue(Catalogue)
	 * @see netlist.NetlistPackage#getCircuit_Catalogue()
	 * @model
	 * @generated
	 */
	Catalogue getCatalogue();

	/**
	 * Sets the value of the '{@link netlist.Circuit#getCatalogue <em>Catalogue</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Catalogue</em>' reference.
	 * @see #getCatalogue()
	 * @generated
	 */
	void setCatalogue(Catalogue value);

	/**
	 * Returns the value of the '<em><b>Instances</b></em>' containment reference list.
	 * The list contents are of type {@link netlist.InstanceComposant}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' containment reference list.
	 * @see netlist.NetlistPackage#getCircuit_Instances()
	 * @model containment="true"
	 * @generated
	 */
	EList<InstanceComposant> getInstances();

	/**
	 * Returns the value of the '<em><b>Connexions</b></em>' containment reference list.
	 * The list contents are of type {@link netlist.Connexion}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connexions</em>' containment reference list.
	 * @see netlist.NetlistPackage#getCircuit_Connexions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Connexion> getConnexions();

	/**
	 * Returns the value of the '<em><b>Commentaires</b></em>' containment reference list.
	 * The list contents are of type {@link netlist.Commentaire}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Commentaires</em>' containment reference list.
	 * @see netlist.NetlistPackage#getCircuit_Commentaires()
	 * @model containment="true"
	 * @generated
	 */
	EList<Commentaire> getCommentaires();

} // Circuit
