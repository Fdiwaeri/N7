/**
 */
package layout.impl;

import java.util.Collection;

import layout.ComposantPosition;
import layout.CoucheExterne;
import layout.LayoutPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Couche Externe</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link layout.impl.CoucheExterneImpl#getComposants <em>Composants</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CoucheExterneImpl extends CoucheImpl implements CoucheExterne {
	/**
	 * The cached value of the '{@link #getComposants() <em>Composants</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComposants()
	 * @generated
	 * @ordered
	 */
	protected EList<ComposantPosition> composants;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoucheExterneImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayoutPackage.Literals.COUCHE_EXTERNE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ComposantPosition> getComposants() {
		if (composants == null) {
			composants = new EObjectContainmentEList<ComposantPosition>(ComposantPosition.class, this, LayoutPackage.COUCHE_EXTERNE__COMPOSANTS);
		}
		return composants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LayoutPackage.COUCHE_EXTERNE__COMPOSANTS:
				return ((InternalEList<?>)getComposants()).basicRemove(otherEnd, msgs);
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
			case LayoutPackage.COUCHE_EXTERNE__COMPOSANTS:
				return getComposants();
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
			case LayoutPackage.COUCHE_EXTERNE__COMPOSANTS:
				getComposants().clear();
				getComposants().addAll((Collection<? extends ComposantPosition>)newValue);
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
			case LayoutPackage.COUCHE_EXTERNE__COMPOSANTS:
				getComposants().clear();
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
			case LayoutPackage.COUCHE_EXTERNE__COMPOSANTS:
				return composants != null && !composants.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CoucheExterneImpl
