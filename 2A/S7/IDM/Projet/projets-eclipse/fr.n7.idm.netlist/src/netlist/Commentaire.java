/**
 */
package netlist;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Commentaire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link netlist.Commentaire#getTexte <em>Texte</em>}</li>
 *   <li>{@link netlist.Commentaire#getAuteur <em>Auteur</em>}</li>
 *   <li>{@link netlist.Commentaire#getDate <em>Date</em>}</li>
 * </ul>
 *
 * @see netlist.NetlistPackage#getCommentaire()
 * @model
 * @generated
 */
public interface Commentaire extends EObject {
	/**
	 * Returns the value of the '<em><b>Texte</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Texte</em>' attribute.
	 * @see #setTexte(String)
	 * @see netlist.NetlistPackage#getCommentaire_Texte()
	 * @model
	 * @generated
	 */
	String getTexte();

	/**
	 * Sets the value of the '{@link netlist.Commentaire#getTexte <em>Texte</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Texte</em>' attribute.
	 * @see #getTexte()
	 * @generated
	 */
	void setTexte(String value);

	/**
	 * Returns the value of the '<em><b>Auteur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auteur</em>' attribute.
	 * @see #setAuteur(String)
	 * @see netlist.NetlistPackage#getCommentaire_Auteur()
	 * @model
	 * @generated
	 */
	String getAuteur();

	/**
	 * Sets the value of the '{@link netlist.Commentaire#getAuteur <em>Auteur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auteur</em>' attribute.
	 * @see #getAuteur()
	 * @generated
	 */
	void setAuteur(String value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(String)
	 * @see netlist.NetlistPackage#getCommentaire_Date()
	 * @model
	 * @generated
	 */
	String getDate();

	/**
	 * Sets the value of the '{@link netlist.Commentaire#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(String value);

} // Commentaire
