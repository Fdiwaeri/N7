/**
 */
package layout;

import netlist.Connexion;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Piste</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link layout.Piste#getNom <em>Nom</em>}</li>
 *   <li>{@link layout.Piste#getLargeur <em>Largeur</em>}</li>
 *   <li>{@link layout.Piste#getPoints <em>Points</em>}</li>
 *   <li>{@link layout.Piste#getConnexion <em>Connexion</em>}</li>
 * </ul>
 *
 * @see layout.LayoutPackage#getPiste()
 * @model
 * @generated
 */
public interface Piste extends EObject {
	/**
	 * Returns the value of the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nom</em>' attribute.
	 * @see #setNom(String)
	 * @see layout.LayoutPackage#getPiste_Nom()
	 * @model
	 * @generated
	 */
	String getNom();

	/**
	 * Sets the value of the '{@link layout.Piste#getNom <em>Nom</em>}' attribute.
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
	 * @see layout.LayoutPackage#getPiste_Largeur()
	 * @model
	 * @generated
	 */
	double getLargeur();

	/**
	 * Sets the value of the '{@link layout.Piste#getLargeur <em>Largeur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Largeur</em>' attribute.
	 * @see #getLargeur()
	 * @generated
	 */
	void setLargeur(double value);

	/**
	 * Returns the value of the '<em><b>Points</b></em>' containment reference list.
	 * The list contents are of type {@link layout.Point}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Points</em>' containment reference list.
	 * @see layout.LayoutPackage#getPiste_Points()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<Point> getPoints();

	/**
	 * Returns the value of the '<em><b>Connexion</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connexion</em>' reference.
	 * @see #setConnexion(Connexion)
	 * @see layout.LayoutPackage#getPiste_Connexion()
	 * @model
	 * @generated
	 */
	Connexion getConnexion();

	/**
	 * Sets the value of the '{@link layout.Piste#getConnexion <em>Connexion</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connexion</em>' reference.
	 * @see #getConnexion()
	 * @generated
	 */
	void setConnexion(Connexion value);

} // Piste
