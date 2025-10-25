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
import petriNet.Place;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Place</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link petriNet.impl.PlaceImpl#getName <em>Name</em>}</li>
 *   <li>{@link petriNet.impl.PlaceImpl#getInitialMarketing <em>Initial Marketing</em>}</li>
 *   <li>{@link petriNet.impl.PlaceImpl#getArcsSortants <em>Arcs Sortants</em>}</li>
 *   <li>{@link petriNet.impl.PlaceImpl#getArcsEntrants <em>Arcs Entrants</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PlaceImpl extends MinimalEObjectImpl.Container implements Place {
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
	 * The default value of the '{@link #getInitialMarketing() <em>Initial Marketing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialMarketing()
	 * @generated
	 * @ordered
	 */
	protected static final int INITIAL_MARKETING_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getInitialMarketing() <em>Initial Marketing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialMarketing()
	 * @generated
	 * @ordered
	 */
	protected int initialMarketing = INITIAL_MARKETING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArcsSortants() <em>Arcs Sortants</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArcsSortants()
	 * @generated
	 * @ordered
	 */
	protected EList<ArcPlaceTransition> arcsSortants;

	/**
	 * The cached value of the '{@link #getArcsEntrants() <em>Arcs Entrants</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArcsEntrants()
	 * @generated
	 * @ordered
	 */
	protected EList<ArcTransitionPlace> arcsEntrants;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PetriNetPackage.Literals.PLACE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PetriNetPackage.PLACE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getInitialMarketing() {
		return initialMarketing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInitialMarketing(int newInitialMarketing) {
		int oldInitialMarketing = initialMarketing;
		initialMarketing = newInitialMarketing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PetriNetPackage.PLACE__INITIAL_MARKETING, oldInitialMarketing, initialMarketing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ArcPlaceTransition> getArcsSortants() {
		if (arcsSortants == null) {
			arcsSortants = new EObjectWithInverseResolvingEList<ArcPlaceTransition>(ArcPlaceTransition.class, this, PetriNetPackage.PLACE__ARCS_SORTANTS, PetriNetPackage.ARC_PLACE_TRANSITION__SOURCE);
		}
		return arcsSortants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ArcTransitionPlace> getArcsEntrants() {
		if (arcsEntrants == null) {
			arcsEntrants = new EObjectWithInverseResolvingEList<ArcTransitionPlace>(ArcTransitionPlace.class, this, PetriNetPackage.PLACE__ARCS_ENTRANTS, PetriNetPackage.ARC_TRANSITION_PLACE__TARGET);
		}
		return arcsEntrants;
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
			case PetriNetPackage.PLACE__ARCS_SORTANTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getArcsSortants()).basicAdd(otherEnd, msgs);
			case PetriNetPackage.PLACE__ARCS_ENTRANTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getArcsEntrants()).basicAdd(otherEnd, msgs);
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
			case PetriNetPackage.PLACE__ARCS_SORTANTS:
				return ((InternalEList<?>)getArcsSortants()).basicRemove(otherEnd, msgs);
			case PetriNetPackage.PLACE__ARCS_ENTRANTS:
				return ((InternalEList<?>)getArcsEntrants()).basicRemove(otherEnd, msgs);
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
			case PetriNetPackage.PLACE__NAME:
				return getName();
			case PetriNetPackage.PLACE__INITIAL_MARKETING:
				return getInitialMarketing();
			case PetriNetPackage.PLACE__ARCS_SORTANTS:
				return getArcsSortants();
			case PetriNetPackage.PLACE__ARCS_ENTRANTS:
				return getArcsEntrants();
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
			case PetriNetPackage.PLACE__NAME:
				setName((String)newValue);
				return;
			case PetriNetPackage.PLACE__INITIAL_MARKETING:
				setInitialMarketing((Integer)newValue);
				return;
			case PetriNetPackage.PLACE__ARCS_SORTANTS:
				getArcsSortants().clear();
				getArcsSortants().addAll((Collection<? extends ArcPlaceTransition>)newValue);
				return;
			case PetriNetPackage.PLACE__ARCS_ENTRANTS:
				getArcsEntrants().clear();
				getArcsEntrants().addAll((Collection<? extends ArcTransitionPlace>)newValue);
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
			case PetriNetPackage.PLACE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PetriNetPackage.PLACE__INITIAL_MARKETING:
				setInitialMarketing(INITIAL_MARKETING_EDEFAULT);
				return;
			case PetriNetPackage.PLACE__ARCS_SORTANTS:
				getArcsSortants().clear();
				return;
			case PetriNetPackage.PLACE__ARCS_ENTRANTS:
				getArcsEntrants().clear();
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
			case PetriNetPackage.PLACE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PetriNetPackage.PLACE__INITIAL_MARKETING:
				return initialMarketing != INITIAL_MARKETING_EDEFAULT;
			case PetriNetPackage.PLACE__ARCS_SORTANTS:
				return arcsSortants != null && !arcsSortants.isEmpty();
			case PetriNetPackage.PLACE__ARCS_ENTRANTS:
				return arcsEntrants != null && !arcsEntrants.isEmpty();
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
		result.append(", initialMarketing: ");
		result.append(initialMarketing);
		result.append(')');
		return result.toString();
	}

} //PlaceImpl
