/**
 */
package petriNet;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link petriNet.Arc#getWeight <em>Weight</em>}</li>
 * </ul>
 *
 * @see petriNet.PetriNetPackage#getArc()
 * @model abstract="true"
 * @generated
 */
public interface Arc extends EObject {
	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see #setWeight(int)
	 * @see petriNet.PetriNetPackage#getArc_Weight()
	 * @model default="1" required="true"
	 * @generated
	 */
	int getWeight();

	/**
	 * Sets the value of the '{@link petriNet.Arc#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(int value);

} // Arc
