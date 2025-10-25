/**
 */
package petriNet;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link petriNet.Transition#getName <em>Name</em>}</li>
 *   <li>{@link petriNet.Transition#getArcsEntrants <em>Arcs Entrants</em>}</li>
 *   <li>{@link petriNet.Transition#getArcsSortants <em>Arcs Sortants</em>}</li>
 * </ul>
 *
 * @see petriNet.PetriNetPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see petriNet.PetriNetPackage#getTransition_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link petriNet.Transition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Arcs Entrants</b></em>' reference list.
	 * The list contents are of type {@link petriNet.ArcPlaceTransition}.
	 * It is bidirectional and its opposite is '{@link petriNet.ArcPlaceTransition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arcs Entrants</em>' reference list.
	 * @see petriNet.PetriNetPackage#getTransition_ArcsEntrants()
	 * @see petriNet.ArcPlaceTransition#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<ArcPlaceTransition> getArcsEntrants();

	/**
	 * Returns the value of the '<em><b>Arcs Sortants</b></em>' reference list.
	 * The list contents are of type {@link petriNet.ArcTransitionPlace}.
	 * It is bidirectional and its opposite is '{@link petriNet.ArcTransitionPlace#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arcs Sortants</em>' reference list.
	 * @see petriNet.PetriNetPackage#getTransition_ArcsSortants()
	 * @see petriNet.ArcTransitionPlace#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<ArcTransitionPlace> getArcsSortants();

} // Transition
