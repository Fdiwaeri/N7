/**
 */
package simplepdl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import simplepdl.Resource;
import simplepdl.SimplepdlPackage;
import simplepdl.UsageResource;
import simplepdl.WorkDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Usage Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link simplepdl.impl.UsageResourceImpl#getUsageQuantity <em>Usage Quantity</em>}</li>
 *   <li>{@link simplepdl.impl.UsageResourceImpl#getUsageTime <em>Usage Time</em>}</li>
 *   <li>{@link simplepdl.impl.UsageResourceImpl#getWorkdefinition <em>Workdefinition</em>}</li>
 *   <li>{@link simplepdl.impl.UsageResourceImpl#getResource <em>Resource</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UsageResourceImpl extends MinimalEObjectImpl.Container implements UsageResource {
	/**
	 * The default value of the '{@link #getUsageQuantity() <em>Usage Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsageQuantity()
	 * @generated
	 * @ordered
	 */
	protected static final int USAGE_QUANTITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getUsageQuantity() <em>Usage Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsageQuantity()
	 * @generated
	 * @ordered
	 */
	protected int usageQuantity = USAGE_QUANTITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getUsageTime() <em>Usage Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsageTime()
	 * @generated
	 * @ordered
	 */
	protected static final int USAGE_TIME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getUsageTime() <em>Usage Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsageTime()
	 * @generated
	 * @ordered
	 */
	protected int usageTime = USAGE_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResource() <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected Resource resource;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UsageResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimplepdlPackage.Literals.USAGE_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getUsageQuantity() {
		return usageQuantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUsageQuantity(int newUsageQuantity) {
		int oldUsageQuantity = usageQuantity;
		usageQuantity = newUsageQuantity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimplepdlPackage.USAGE_RESOURCE__USAGE_QUANTITY, oldUsageQuantity, usageQuantity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getUsageTime() {
		return usageTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUsageTime(int newUsageTime) {
		int oldUsageTime = usageTime;
		usageTime = newUsageTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimplepdlPackage.USAGE_RESOURCE__USAGE_TIME, oldUsageTime, usageTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WorkDefinition getWorkdefinition() {
		if (eContainerFeatureID() != SimplepdlPackage.USAGE_RESOURCE__WORKDEFINITION) return null;
		return (WorkDefinition)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWorkdefinition(WorkDefinition newWorkdefinition, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newWorkdefinition, SimplepdlPackage.USAGE_RESOURCE__WORKDEFINITION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWorkdefinition(WorkDefinition newWorkdefinition) {
		if (newWorkdefinition != eInternalContainer() || (eContainerFeatureID() != SimplepdlPackage.USAGE_RESOURCE__WORKDEFINITION && newWorkdefinition != null)) {
			if (EcoreUtil.isAncestor(this, newWorkdefinition))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newWorkdefinition != null)
				msgs = ((InternalEObject)newWorkdefinition).eInverseAdd(this, SimplepdlPackage.WORK_DEFINITION__USES, WorkDefinition.class, msgs);
			msgs = basicSetWorkdefinition(newWorkdefinition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimplepdlPackage.USAGE_RESOURCE__WORKDEFINITION, newWorkdefinition, newWorkdefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Resource getResource() {
		if (resource != null && resource.eIsProxy()) {
			InternalEObject oldResource = (InternalEObject)resource;
			resource = (Resource)eResolveProxy(oldResource);
			if (resource != oldResource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimplepdlPackage.USAGE_RESOURCE__RESOURCE, oldResource, resource));
			}
		}
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource basicGetResource() {
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResource(Resource newResource, NotificationChain msgs) {
		Resource oldResource = resource;
		resource = newResource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimplepdlPackage.USAGE_RESOURCE__RESOURCE, oldResource, newResource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResource(Resource newResource) {
		if (newResource != resource) {
			NotificationChain msgs = null;
			if (resource != null)
				msgs = ((InternalEObject)resource).eInverseRemove(this, SimplepdlPackage.RESOURCE__USAGERESOURCES, Resource.class, msgs);
			if (newResource != null)
				msgs = ((InternalEObject)newResource).eInverseAdd(this, SimplepdlPackage.RESOURCE__USAGERESOURCES, Resource.class, msgs);
			msgs = basicSetResource(newResource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimplepdlPackage.USAGE_RESOURCE__RESOURCE, newResource, newResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimplepdlPackage.USAGE_RESOURCE__WORKDEFINITION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetWorkdefinition((WorkDefinition)otherEnd, msgs);
			case SimplepdlPackage.USAGE_RESOURCE__RESOURCE:
				if (resource != null)
					msgs = ((InternalEObject)resource).eInverseRemove(this, SimplepdlPackage.RESOURCE__USAGERESOURCES, Resource.class, msgs);
				return basicSetResource((Resource)otherEnd, msgs);
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
			case SimplepdlPackage.USAGE_RESOURCE__WORKDEFINITION:
				return basicSetWorkdefinition(null, msgs);
			case SimplepdlPackage.USAGE_RESOURCE__RESOURCE:
				return basicSetResource(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SimplepdlPackage.USAGE_RESOURCE__WORKDEFINITION:
				return eInternalContainer().eInverseRemove(this, SimplepdlPackage.WORK_DEFINITION__USES, WorkDefinition.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimplepdlPackage.USAGE_RESOURCE__USAGE_QUANTITY:
				return getUsageQuantity();
			case SimplepdlPackage.USAGE_RESOURCE__USAGE_TIME:
				return getUsageTime();
			case SimplepdlPackage.USAGE_RESOURCE__WORKDEFINITION:
				return getWorkdefinition();
			case SimplepdlPackage.USAGE_RESOURCE__RESOURCE:
				if (resolve) return getResource();
				return basicGetResource();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SimplepdlPackage.USAGE_RESOURCE__USAGE_QUANTITY:
				setUsageQuantity((Integer)newValue);
				return;
			case SimplepdlPackage.USAGE_RESOURCE__USAGE_TIME:
				setUsageTime((Integer)newValue);
				return;
			case SimplepdlPackage.USAGE_RESOURCE__WORKDEFINITION:
				setWorkdefinition((WorkDefinition)newValue);
				return;
			case SimplepdlPackage.USAGE_RESOURCE__RESOURCE:
				setResource((Resource)newValue);
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
			case SimplepdlPackage.USAGE_RESOURCE__USAGE_QUANTITY:
				setUsageQuantity(USAGE_QUANTITY_EDEFAULT);
				return;
			case SimplepdlPackage.USAGE_RESOURCE__USAGE_TIME:
				setUsageTime(USAGE_TIME_EDEFAULT);
				return;
			case SimplepdlPackage.USAGE_RESOURCE__WORKDEFINITION:
				setWorkdefinition((WorkDefinition)null);
				return;
			case SimplepdlPackage.USAGE_RESOURCE__RESOURCE:
				setResource((Resource)null);
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
			case SimplepdlPackage.USAGE_RESOURCE__USAGE_QUANTITY:
				return usageQuantity != USAGE_QUANTITY_EDEFAULT;
			case SimplepdlPackage.USAGE_RESOURCE__USAGE_TIME:
				return usageTime != USAGE_TIME_EDEFAULT;
			case SimplepdlPackage.USAGE_RESOURCE__WORKDEFINITION:
				return getWorkdefinition() != null;
			case SimplepdlPackage.USAGE_RESOURCE__RESOURCE:
				return resource != null;
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
		result.append(" (UsageQuantity: ");
		result.append(usageQuantity);
		result.append(", UsageTime: ");
		result.append(usageTime);
		result.append(')');
		return result.toString();
	}

} //UsageResourceImpl
