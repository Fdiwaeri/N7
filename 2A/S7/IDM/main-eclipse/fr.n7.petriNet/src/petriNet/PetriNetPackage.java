/**
 */
package petriNet;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see petriNet.PetriNetFactory
 * @model kind="package"
 * @generated
 */
public interface PetriNetPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "petriNet";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "platform:/resource/fr.n7.petriNet/PetriNet.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "petriNet";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PetriNetPackage eINSTANCE = petriNet.impl.PetriNetPackageImpl.init();

	/**
	 * The meta object id for the '{@link petriNet.impl.PetriNetImpl <em>Petri Net</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see petriNet.impl.PetriNetImpl
	 * @see petriNet.impl.PetriNetPackageImpl#getPetriNet()
	 * @generated
	 */
	int PETRI_NET = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET__NAME = 0;

	/**
	 * The feature id for the '<em><b>Places</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET__PLACES = 1;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET__TRANSITIONS = 2;

	/**
	 * The feature id for the '<em><b>Arcs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET__ARCS = 3;

	/**
	 * The number of structural features of the '<em>Petri Net</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Petri Net</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link petriNet.impl.PlaceImpl <em>Place</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see petriNet.impl.PlaceImpl
	 * @see petriNet.impl.PetriNetPackageImpl#getPlace()
	 * @generated
	 */
	int PLACE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Initial Marketing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__INITIAL_MARKETING = 1;

	/**
	 * The feature id for the '<em><b>Arcs Sortants</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__ARCS_SORTANTS = 2;

	/**
	 * The feature id for the '<em><b>Arcs Entrants</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__ARCS_ENTRANTS = 3;

	/**
	 * The number of structural features of the '<em>Place</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Place</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link petriNet.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see petriNet.impl.TransitionImpl
	 * @see petriNet.impl.PetriNetPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Arcs Entrants</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ARCS_ENTRANTS = 1;

	/**
	 * The feature id for the '<em><b>Arcs Sortants</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ARCS_SORTANTS = 2;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link petriNet.impl.ArcImpl <em>Arc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see petriNet.impl.ArcImpl
	 * @see petriNet.impl.PetriNetPackageImpl#getArc()
	 * @generated
	 */
	int ARC = 3;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__WEIGHT = 0;

	/**
	 * The number of structural features of the '<em>Arc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Arc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link petriNet.impl.ArcPlaceTransitionImpl <em>Arc Place Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see petriNet.impl.ArcPlaceTransitionImpl
	 * @see petriNet.impl.PetriNetPackageImpl#getArcPlaceTransition()
	 * @generated
	 */
	int ARC_PLACE_TRANSITION = 4;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_PLACE_TRANSITION__WEIGHT = ARC__WEIGHT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_PLACE_TRANSITION__SOURCE = ARC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_PLACE_TRANSITION__TARGET = ARC_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Arc Place Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_PLACE_TRANSITION_FEATURE_COUNT = ARC_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Arc Place Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_PLACE_TRANSITION_OPERATION_COUNT = ARC_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link petriNet.impl.ArcTransitionPlaceImpl <em>Arc Transition Place</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see petriNet.impl.ArcTransitionPlaceImpl
	 * @see petriNet.impl.PetriNetPackageImpl#getArcTransitionPlace()
	 * @generated
	 */
	int ARC_TRANSITION_PLACE = 5;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_TRANSITION_PLACE__WEIGHT = ARC__WEIGHT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_TRANSITION_PLACE__SOURCE = ARC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_TRANSITION_PLACE__TARGET = ARC_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Arc Transition Place</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_TRANSITION_PLACE_FEATURE_COUNT = ARC_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Arc Transition Place</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_TRANSITION_PLACE_OPERATION_COUNT = ARC_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link petriNet.PetriNet <em>Petri Net</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Petri Net</em>'.
	 * @see petriNet.PetriNet
	 * @generated
	 */
	EClass getPetriNet();

	/**
	 * Returns the meta object for the attribute '{@link petriNet.PetriNet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see petriNet.PetriNet#getName()
	 * @see #getPetriNet()
	 * @generated
	 */
	EAttribute getPetriNet_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link petriNet.PetriNet#getPlaces <em>Places</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Places</em>'.
	 * @see petriNet.PetriNet#getPlaces()
	 * @see #getPetriNet()
	 * @generated
	 */
	EReference getPetriNet_Places();

	/**
	 * Returns the meta object for the containment reference list '{@link petriNet.PetriNet#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see petriNet.PetriNet#getTransitions()
	 * @see #getPetriNet()
	 * @generated
	 */
	EReference getPetriNet_Transitions();

	/**
	 * Returns the meta object for the containment reference list '{@link petriNet.PetriNet#getArcs <em>Arcs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arcs</em>'.
	 * @see petriNet.PetriNet#getArcs()
	 * @see #getPetriNet()
	 * @generated
	 */
	EReference getPetriNet_Arcs();

	/**
	 * Returns the meta object for class '{@link petriNet.Place <em>Place</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Place</em>'.
	 * @see petriNet.Place
	 * @generated
	 */
	EClass getPlace();

	/**
	 * Returns the meta object for the attribute '{@link petriNet.Place#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see petriNet.Place#getName()
	 * @see #getPlace()
	 * @generated
	 */
	EAttribute getPlace_Name();

	/**
	 * Returns the meta object for the attribute '{@link petriNet.Place#getInitialMarketing <em>Initial Marketing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial Marketing</em>'.
	 * @see petriNet.Place#getInitialMarketing()
	 * @see #getPlace()
	 * @generated
	 */
	EAttribute getPlace_InitialMarketing();

	/**
	 * Returns the meta object for the reference list '{@link petriNet.Place#getArcsSortants <em>Arcs Sortants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Arcs Sortants</em>'.
	 * @see petriNet.Place#getArcsSortants()
	 * @see #getPlace()
	 * @generated
	 */
	EReference getPlace_ArcsSortants();

	/**
	 * Returns the meta object for the reference list '{@link petriNet.Place#getArcsEntrants <em>Arcs Entrants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Arcs Entrants</em>'.
	 * @see petriNet.Place#getArcsEntrants()
	 * @see #getPlace()
	 * @generated
	 */
	EReference getPlace_ArcsEntrants();

	/**
	 * Returns the meta object for class '{@link petriNet.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see petriNet.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the attribute '{@link petriNet.Transition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see petriNet.Transition#getName()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Name();

	/**
	 * Returns the meta object for the reference list '{@link petriNet.Transition#getArcsEntrants <em>Arcs Entrants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Arcs Entrants</em>'.
	 * @see petriNet.Transition#getArcsEntrants()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_ArcsEntrants();

	/**
	 * Returns the meta object for the reference list '{@link petriNet.Transition#getArcsSortants <em>Arcs Sortants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Arcs Sortants</em>'.
	 * @see petriNet.Transition#getArcsSortants()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_ArcsSortants();

	/**
	 * Returns the meta object for class '{@link petriNet.Arc <em>Arc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arc</em>'.
	 * @see petriNet.Arc
	 * @generated
	 */
	EClass getArc();

	/**
	 * Returns the meta object for the attribute '{@link petriNet.Arc#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see petriNet.Arc#getWeight()
	 * @see #getArc()
	 * @generated
	 */
	EAttribute getArc_Weight();

	/**
	 * Returns the meta object for class '{@link petriNet.ArcPlaceTransition <em>Arc Place Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arc Place Transition</em>'.
	 * @see petriNet.ArcPlaceTransition
	 * @generated
	 */
	EClass getArcPlaceTransition();

	/**
	 * Returns the meta object for the reference '{@link petriNet.ArcPlaceTransition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see petriNet.ArcPlaceTransition#getSource()
	 * @see #getArcPlaceTransition()
	 * @generated
	 */
	EReference getArcPlaceTransition_Source();

	/**
	 * Returns the meta object for the reference '{@link petriNet.ArcPlaceTransition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see petriNet.ArcPlaceTransition#getTarget()
	 * @see #getArcPlaceTransition()
	 * @generated
	 */
	EReference getArcPlaceTransition_Target();

	/**
	 * Returns the meta object for class '{@link petriNet.ArcTransitionPlace <em>Arc Transition Place</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arc Transition Place</em>'.
	 * @see petriNet.ArcTransitionPlace
	 * @generated
	 */
	EClass getArcTransitionPlace();

	/**
	 * Returns the meta object for the reference '{@link petriNet.ArcTransitionPlace#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see petriNet.ArcTransitionPlace#getSource()
	 * @see #getArcTransitionPlace()
	 * @generated
	 */
	EReference getArcTransitionPlace_Source();

	/**
	 * Returns the meta object for the reference '{@link petriNet.ArcTransitionPlace#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see petriNet.ArcTransitionPlace#getTarget()
	 * @see #getArcTransitionPlace()
	 * @generated
	 */
	EReference getArcTransitionPlace_Target();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PetriNetFactory getPetriNetFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link petriNet.impl.PetriNetImpl <em>Petri Net</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see petriNet.impl.PetriNetImpl
		 * @see petriNet.impl.PetriNetPackageImpl#getPetriNet()
		 * @generated
		 */
		EClass PETRI_NET = eINSTANCE.getPetriNet();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PETRI_NET__NAME = eINSTANCE.getPetriNet_Name();

		/**
		 * The meta object literal for the '<em><b>Places</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PETRI_NET__PLACES = eINSTANCE.getPetriNet_Places();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PETRI_NET__TRANSITIONS = eINSTANCE.getPetriNet_Transitions();

		/**
		 * The meta object literal for the '<em><b>Arcs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PETRI_NET__ARCS = eINSTANCE.getPetriNet_Arcs();

		/**
		 * The meta object literal for the '{@link petriNet.impl.PlaceImpl <em>Place</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see petriNet.impl.PlaceImpl
		 * @see petriNet.impl.PetriNetPackageImpl#getPlace()
		 * @generated
		 */
		EClass PLACE = eINSTANCE.getPlace();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLACE__NAME = eINSTANCE.getPlace_Name();

		/**
		 * The meta object literal for the '<em><b>Initial Marketing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLACE__INITIAL_MARKETING = eINSTANCE.getPlace_InitialMarketing();

		/**
		 * The meta object literal for the '<em><b>Arcs Sortants</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACE__ARCS_SORTANTS = eINSTANCE.getPlace_ArcsSortants();

		/**
		 * The meta object literal for the '<em><b>Arcs Entrants</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACE__ARCS_ENTRANTS = eINSTANCE.getPlace_ArcsEntrants();

		/**
		 * The meta object literal for the '{@link petriNet.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see petriNet.impl.TransitionImpl
		 * @see petriNet.impl.PetriNetPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__NAME = eINSTANCE.getTransition_Name();

		/**
		 * The meta object literal for the '<em><b>Arcs Entrants</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__ARCS_ENTRANTS = eINSTANCE.getTransition_ArcsEntrants();

		/**
		 * The meta object literal for the '<em><b>Arcs Sortants</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__ARCS_SORTANTS = eINSTANCE.getTransition_ArcsSortants();

		/**
		 * The meta object literal for the '{@link petriNet.impl.ArcImpl <em>Arc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see petriNet.impl.ArcImpl
		 * @see petriNet.impl.PetriNetPackageImpl#getArc()
		 * @generated
		 */
		EClass ARC = eINSTANCE.getArc();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARC__WEIGHT = eINSTANCE.getArc_Weight();

		/**
		 * The meta object literal for the '{@link petriNet.impl.ArcPlaceTransitionImpl <em>Arc Place Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see petriNet.impl.ArcPlaceTransitionImpl
		 * @see petriNet.impl.PetriNetPackageImpl#getArcPlaceTransition()
		 * @generated
		 */
		EClass ARC_PLACE_TRANSITION = eINSTANCE.getArcPlaceTransition();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARC_PLACE_TRANSITION__SOURCE = eINSTANCE.getArcPlaceTransition_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARC_PLACE_TRANSITION__TARGET = eINSTANCE.getArcPlaceTransition_Target();

		/**
		 * The meta object literal for the '{@link petriNet.impl.ArcTransitionPlaceImpl <em>Arc Transition Place</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see petriNet.impl.ArcTransitionPlaceImpl
		 * @see petriNet.impl.PetriNetPackageImpl#getArcTransitionPlace()
		 * @generated
		 */
		EClass ARC_TRANSITION_PLACE = eINSTANCE.getArcTransitionPlace();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARC_TRANSITION_PLACE__SOURCE = eINSTANCE.getArcTransitionPlace_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARC_TRANSITION_PLACE__TARGET = eINSTANCE.getArcTransitionPlace_Target();

	}

} //PetriNetPackage
