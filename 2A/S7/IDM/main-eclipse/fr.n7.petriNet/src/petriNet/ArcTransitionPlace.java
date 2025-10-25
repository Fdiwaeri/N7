/**
 */
package petriNet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arc Transition Place</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link petriNet.ArcTransitionPlace#getSource <em>Source</em>}</li>
 *   <li>{@link petriNet.ArcTransitionPlace#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see petriNet.PetriNetPackage#getArcTransitionPlace()
 * @model
 * @generated
 */
public interface ArcTransitionPlace extends Arc {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link petriNet.Transition#getArcsSortants <em>Arcs Sortants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Transition)
	 * @see petriNet.PetriNetPackage#getArcTransitionPlace_Source()
	 * @see petriNet.Transition#getArcsSortants
	 * @model opposite="arcsSortants" required="true"
	 * @generated
	 */
	Transition getSource();

	/**
	 * Sets the value of the '{@link petriNet.ArcTransitionPlace#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Transition value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link petriNet.Place#getArcsEntrants <em>Arcs Entrants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Place)
	 * @see petriNet.PetriNetPackage#getArcTransitionPlace_Target()
	 * @see petriNet.Place#getArcsEntrants
	 * @model opposite="arcsEntrants" required="true"
	 * @generated
	 */
	Place getTarget();

	/**
	 * Sets the value of the '{@link petriNet.ArcTransitionPlace#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Place value);

} // ArcTransitionPlace
