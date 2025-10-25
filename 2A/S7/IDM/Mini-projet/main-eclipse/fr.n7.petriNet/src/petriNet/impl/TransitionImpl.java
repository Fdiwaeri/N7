/**
 */
package petriNet.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import petriNet.ArcPlaceTransition;
import petriNet.ArcTransitionPlace;
import petriNet.PetriNetPackage;
import petriNet.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link petriNet.impl.TransitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link petriNet.impl.TransitionImpl#getArcsEntrants <em>Arcs Entrants</em>}</li>
 *   <li>{@link petriNet.impl.TransitionImpl#getArcsSortants <em>Arcs Sortants</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends MinimalEObjectImpl.Container implements Transition {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArcsEntrants() <em>Arcs Entrants</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArcsEntrants()
	 * @generated
	 * @ordered
	 */
	protected EList<ArcPlaceTransition> arcsEntrants;

	/**
	 * The cached value of the '{@link #getArcsSortants() <em>Arcs Sortants</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArcsSortants()
	 * @generated
	 * @ordered
	 */
	protected EList<ArcTransitionPlace> arcsSortants;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PetriNetPackage.Literals.TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PetriNetPackage.TRANSITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ArcPlaceTransition> getArcsEntrants() {
		if (arcsEntrants == null) {
			arcsEntrants = new EObjectWithInverseResolvingEList<ArcPlaceTransition>(ArcPlaceTransition.class, this, PetriNetPackage.TRANSITION__ARCS_ENTRANTS, PetriNetPackage.ARC_PLACE_TRANSITION__TARGET);
		}
		return arcsEntrants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ArcTransitionPlace> getArcsSortants() {
		if (arcsSortants == null) {
			arcsSortants = new EObjectWithInverseResolvingEList<ArcTransitionPlace>(ArcTransitionPlace.class, this, PetriNetPackage.TRANSITION__ARCS_SORTANTS, PetriNetPackage.ARC_TRANSITION_PLACE__SOURCE);
		}
		return arcsSortants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PetriNetPackage.TRANSITION__ARCS_ENTRANTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getArcsEntrants()).basicAdd(otherEnd, msgs);
			case PetriNetPackage.TRANSITION__ARCS_SORTANTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getArcsSortants()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PetriNetPackage.TRANSITION__ARCS_ENTRANTS:
				return ((InternalEList<?>)getArcsEntrants()).basicRemove(otherEnd, msgs);
			case PetriNetPackage.TRANSITION__ARCS_SORTANTS:
				return ((InternalEList<?>)getArcsSortants()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PetriNetPackage.TRANSITION__NAME:
				return getName();
			case PetriNetPackage.TRANSITION__ARCS_ENTRANTS:
				return getArcsEntrants();
			case PetriNetPackage.TRANSITION__ARCS_SORTANTS:
				return getArcsSortants();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PetriNetPackage.TRANSITION__NAME:
				setName((String)newValue);
				return;
			case PetriNetPackage.TRANSITION__ARCS_ENTRANTS:
				getArcsEntrants().clear();
				getArcsEntrants().addAll((Collection<? extends ArcPlaceTransition>)newValue);
				return;
			case PetriNetPackage.TRANSITION__ARCS_SORTANTS:
				getArcsSortants().clear();
				getArcsSortants().addAll((Collection<? extends ArcTransitionPlace>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PetriNetPackage.TRANSITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PetriNetPackage.TRANSITION__ARCS_ENTRANTS:
				getArcsEntrants().clear();
				return;
			case PetriNetPackage.TRANSITION__ARCS_SORTANTS:
				getArcsSortants().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PetriNetPackage.TRANSITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PetriNetPackage.TRANSITION__ARCS_ENTRANTS:
				return arcsEntrants != null && !arcsEntrants.isEmpty();
			case PetriNetPackage.TRANSITION__ARCS_SORTANTS:
				return arcsSortants != null && !arcsSortants.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //TransitionImpl
