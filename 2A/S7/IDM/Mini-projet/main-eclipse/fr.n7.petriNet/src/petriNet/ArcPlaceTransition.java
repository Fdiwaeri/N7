/**
 */
package petriNet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arc Place Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link petriNet.ArcPlaceTransition#getSource <em>Source</em>}</li>
 *   <li>{@link petriNet.ArcPlaceTransition#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see petriNet.PetriNetPackage#getArcPlaceTransition()
 * @model
 * @generated
 */
public interface ArcPlaceTransition extends Arc {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link petriNet.Place#getArcsSortants <em>Arcs Sortants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Place)
	 * @see petriNet.PetriNetPackage#getArcPlaceTransition_Source()
	 * @see petriNet.Place#getArcsSortants
	 * @model opposite="arcsSortants" required="true"
	 * @generated
	 */
	Place getSource();

	/**
	 * Sets the value of the '{@link petriNet.ArcPlaceTransition#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Place value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link petriNet.Transition#getArcsEntrants <em>Arcs Entrants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Transition)
	 * @see petriNet.PetriNetPackage#getArcPlaceTransition_Target()
	 * @see petriNet.Transition#getArcsEntrants
	 * @model opposite="arcsEntrants" required="true"
	 * @generated
	 */
	Transition getTarget();

	/**
	 * Sets the value of the '{@link petriNet.ArcPlaceTransition#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Transition value);

} // ArcPlaceTransition
