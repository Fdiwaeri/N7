/**
 */
package layout;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Couche Externe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link layout.CoucheExterne#getComposants <em>Composants</em>}</li>
 * </ul>
 *
 * @see layout.LayoutPackage#getCoucheExterne()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='nonChevauchement'"
 * @generated
 */
public interface CoucheExterne extends Couche {
	/**
	 * Returns the value of the '<em><b>Composants</b></em>' containment reference list.
	 * The list contents are of type {@link layout.ComposantPosition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composants</em>' containment reference list.
	 * @see layout.LayoutPackage#getCoucheExterne_Composants()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComposantPosition> getComposants();

} // CoucheExterne
