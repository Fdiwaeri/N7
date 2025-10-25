/**
 */
package petriNet;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Place</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link petriNet.Place#getName <em>Name</em>}</li>
 *   <li>{@link petriNet.Place#getInitialMarketing <em>Initial Marketing</em>}</li>
 *   <li>{@link petriNet.Place#getArcsSortants <em>Arcs Sortants</em>}</li>
 *   <li>{@link petriNet.Place#getArcsEntrants <em>Arcs Entrants</em>}</li>
 * </ul>
 *
 * @see petriNet.PetriNetPackage#getPlace()
 * @model
 * @generated
 */
public interface Place extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see petriNet.PetriNetPackage#getPlace_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link petriNet.Place#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Initial Marketing</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Marketing</em>' attribute.
	 * @see #setInitialMarketing(int)
	 * @see petriNet.PetriNetPackage#getPlace_InitialMarketing()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getInitialMarketing();

	/**
	 * Sets the value of the '{@link petriNet.Place#getInitialMarketing <em>Initial Marketing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Marketing</em>' attribute.
	 * @see #getInitialMarketing()
	 * @generated
	 */
	void setInitialMarketing(int value);

	/**
	 * Returns the value of the '<em><b>Arcs Sortants</b></em>' reference list.
	 * The list contents are of type {@link petriNet.ArcPlaceTransition}.
	 * It is bidirectional and its opposite is '{@link petriNet.ArcPlaceTransition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arcs Sortants</em>' reference list.
	 * @see petriNet.PetriNetPackage#getPlace_ArcsSortants()
	 * @see petriNet.ArcPlaceTransition#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<ArcPlaceTransition> getArcsSortants();

	/**
	 * Returns the value of the '<em><b>Arcs Entrants</b></em>' reference list.
	 * The list contents are of type {@link petriNet.ArcTransitionPlace}.
	 * It is bidirectional and its opposite is '{@link petriNet.ArcTransitionPlace#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arcs Entrants</em>' reference list.
	 * @see petriNet.PetriNetPackage#getPlace_ArcsEntrants()
	 * @see petriNet.ArcTransitionPlace#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<ArcTransitionPlace> getArcsEntrants();

} // Place
