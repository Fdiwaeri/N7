/**
 */
package netlist.impl;

import fr.n7.idm.catalogue.Catalogue;

import java.util.Collection;

import netlist.Circuit;
import netlist.Commentaire;
import netlist.Connexion;
import netlist.InstanceComposant;
import netlist.NetlistPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Circuit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link netlist.impl.CircuitImpl#getNom <em>Nom</em>}</li>
 *   <li>{@link netlist.impl.CircuitImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link netlist.impl.CircuitImpl#getCatalogue <em>Catalogue</em>}</li>
 *   <li>{@link netlist.impl.CircuitImpl#getInstances <em>Instances</em>}</li>
 *   <li>{@link netlist.impl.CircuitImpl#getConnexions <em>Connexions</em>}</li>
 *   <li>{@link netlist.impl.CircuitImpl#getCommentaires <em>Commentaires</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CircuitImpl extends MinimalEObjectImpl.Container implements Circuit {
	/**
	 * The default value of the '{@link #getNom() <em>Nom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNom()
	 * @generated
	 * @ordered
	 */
	protected static final String NOM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNom() <em>Nom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNom()
	 * @generated
	 * @ordered
	 */
	protected String nom = NOM_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCatalogue() <em>Catalogue</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatalogue()
	 * @generated
	 * @ordered
	 */
	protected Catalogue catalogue;

	/**
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<InstanceComposant> instances;

	/**
	 * The cached value of the '{@link #getConnexions() <em>Connexions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnexions()
	 * @generated
	 * @ordered
	 */
	protected EList<Connexion> connexions;

	/**
	 * The cached value of the '{@link #getCommentaires() <em>Commentaires</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommentaires()
	 * @generated
	 * @ordered
	 */
	protected EList<Commentaire> commentaires;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CircuitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NetlistPackage.Literals.CIRCUIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNom() {
		return nom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNom(String newNom) {
		String oldNom = nom;
		nom = newNom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetlistPackage.CIRCUIT__NOM, oldNom, nom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetlistPackage.CIRCUIT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Catalogue getCatalogue() {
		if (catalogue != null && catalogue.eIsProxy()) {
			InternalEObject oldCatalogue = (InternalEObject)catalogue;
			catalogue = (Catalogue)eResolveProxy(oldCatalogue);
			if (catalogue != oldCatalogue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NetlistPackage.CIRCUIT__CATALOGUE, oldCatalogue, catalogue));
			}
		}
		return catalogue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Catalogue basicGetCatalogue() {
		return catalogue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCatalogue(Catalogue newCatalogue) {
		Catalogue oldCatalogue = catalogue;
		catalogue = newCatalogue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetlistPackage.CIRCUIT__CATALOGUE, oldCatalogue, catalogue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<InstanceComposant> getInstances() {
		if (instances == null) {
			instances = new EObjectContainmentEList<InstanceComposant>(InstanceComposant.class, this, NetlistPackage.CIRCUIT__INSTANCES);
		}
		return instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Connexion> getConnexions() {
		if (connexions == null) {
			connexions = new EObjectContainmentEList<Connexion>(Connexion.class, this, NetlistPackage.CIRCUIT__CONNEXIONS);
		}
		return connexions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Commentaire> getCommentaires() {
		if (commentaires == null) {
			commentaires = new EObjectContainmentEList<Commentaire>(Commentaire.class, this, NetlistPackage.CIRCUIT__COMMENTAIRES);
		}
		return commentaires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NetlistPackage.CIRCUIT__INSTANCES:
				return ((InternalEList<?>)getInstances()).basicRemove(otherEnd, msgs);
			case NetlistPackage.CIRCUIT__CONNEXIONS:
				return ((InternalEList<?>)getConnexions()).basicRemove(otherEnd, msgs);
			case NetlistPackage.CIRCUIT__COMMENTAIRES:
				return ((InternalEList<?>)getCommentaires()).basicRemove(otherEnd, msgs);
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
			case NetlistPackage.CIRCUIT__NOM:
				return getNom();
			case NetlistPackage.CIRCUIT__DESCRIPTION:
				return getDescription();
			case NetlistPackage.CIRCUIT__CATALOGUE:
				if (resolve) return getCatalogue();
				return basicGetCatalogue();
			case NetlistPackage.CIRCUIT__INSTANCES:
				return getInstances();
			case NetlistPackage.CIRCUIT__CONNEXIONS:
				return getConnexions();
			case NetlistPackage.CIRCUIT__COMMENTAIRES:
				return getCommentaires();
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
			case NetlistPackage.CIRCUIT__NOM:
				setNom((String)newValue);
				return;
			case NetlistPackage.CIRCUIT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case NetlistPackage.CIRCUIT__CATALOGUE:
				setCatalogue((Catalogue)newValue);
				return;
			case NetlistPackage.CIRCUIT__INSTANCES:
				getInstances().clear();
				getInstances().addAll((Collection<? extends InstanceComposant>)newValue);
				return;
			case NetlistPackage.CIRCUIT__CONNEXIONS:
				getConnexions().clear();
				getConnexions().addAll((Collection<? extends Connexion>)newValue);
				return;
			case NetlistPackage.CIRCUIT__COMMENTAIRES:
				getCommentaires().clear();
				getCommentaires().addAll((Collection<? extends Commentaire>)newValue);
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
			case NetlistPackage.CIRCUIT__NOM:
				setNom(NOM_EDEFAULT);
				return;
			case NetlistPackage.CIRCUIT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case NetlistPackage.CIRCUIT__CATALOGUE:
				setCatalogue((Catalogue)null);
				return;
			case NetlistPackage.CIRCUIT__INSTANCES:
				getInstances().clear();
				return;
			case NetlistPackage.CIRCUIT__CONNEXIONS:
				getConnexions().clear();
				return;
			case NetlistPackage.CIRCUIT__COMMENTAIRES:
				getCommentaires().clear();
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
			case NetlistPackage.CIRCUIT__NOM:
				return NOM_EDEFAULT == null ? nom != null : !NOM_EDEFAULT.equals(nom);
			case NetlistPackage.CIRCUIT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case NetlistPackage.CIRCUIT__CATALOGUE:
				return catalogue != null;
			case NetlistPackage.CIRCUIT__INSTANCES:
				return instances != null && !instances.isEmpty();
			case NetlistPackage.CIRCUIT__CONNEXIONS:
				return connexions != null && !connexions.isEmpty();
			case NetlistPackage.CIRCUIT__COMMENTAIRES:
				return commentaires != null && !commentaires.isEmpty();
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
		result.append(" (nom: ");
		result.append(nom);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //CircuitImpl
