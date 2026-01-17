/**
 */
package layout;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Board</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link layout.Board#getNom <em>Nom</em>}</li>
 *   <li>{@link layout.Board#getLargeur <em>Largeur</em>}</li>
 *   <li>{@link layout.Board#getHauteur <em>Hauteur</em>}</li>
 *   <li>{@link layout.Board#getCouches <em>Couches</em>}</li>
 * </ul>
 *
 * @see layout.LayoutPackage#getBoard()
 * @model
 * @generated
 */
public interface Board extends EObject {
	/**
	 * Returns the value of the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nom</em>' attribute.
	 * @see #setNom(String)
	 * @see layout.LayoutPackage#getBoard_Nom()
	 * @model
	 * @generated
	 */
	String getNom();

	/**
	 * Sets the value of the '{@link layout.Board#getNom <em>Nom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nom</em>' attribute.
	 * @see #getNom()
	 * @generated
	 */
	void setNom(String value);

	/**
	 * Returns the value of the '<em><b>Largeur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Largeur</em>' attribute.
	 * @see #setLargeur(double)
	 * @see layout.LayoutPackage#getBoard_Largeur()
	 * @model
	 * @generated
	 */
	double getLargeur();

	/**
	 * Sets the value of the '{@link layout.Board#getLargeur <em>Largeur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Largeur</em>' attribute.
	 * @see #getLargeur()
	 * @generated
	 */
	void setLargeur(double value);

	/**
	 * Returns the value of the '<em><b>Hauteur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hauteur</em>' attribute.
	 * @see #setHauteur(double)
	 * @see layout.LayoutPackage#getBoard_Hauteur()
	 * @model
	 * @generated
	 */
	double getHauteur();

	/**
	 * Sets the value of the '{@link layout.Board#getHauteur <em>Hauteur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hauteur</em>' attribute.
	 * @see #getHauteur()
	 * @generated
	 */
	void setHauteur(double value);

	/**
	 * Returns the value of the '<em><b>Couches</b></em>' containment reference list.
	 * The list contents are of type {@link layout.Couche}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Couches</em>' containment reference list.
	 * @see layout.LayoutPackage#getBoard_Couches()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Couche> getCouches();

} // Board
