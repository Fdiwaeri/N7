/**
 */
package layout.impl;

import java.util.Collection;

import layout.Board;
import layout.Couche;
import layout.LayoutPackage;

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
 * An implementation of the model object '<em><b>Board</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link layout.impl.BoardImpl#getNom <em>Nom</em>}</li>
 *   <li>{@link layout.impl.BoardImpl#getLargeur <em>Largeur</em>}</li>
 *   <li>{@link layout.impl.BoardImpl#getHauteur <em>Hauteur</em>}</li>
 *   <li>{@link layout.impl.BoardImpl#getCouches <em>Couches</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BoardImpl extends MinimalEObjectImpl.Container implements Board {
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
	 * The default value of the '{@link #getLargeur() <em>Largeur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLargeur()
	 * @generated
	 * @ordered
	 */
	protected static final double LARGEUR_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLargeur() <em>Largeur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLargeur()
	 * @generated
	 * @ordered
	 */
	protected double largeur = LARGEUR_EDEFAULT;

	/**
	 * The default value of the '{@link #getHauteur() <em>Hauteur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHauteur()
	 * @generated
	 * @ordered
	 */
	protected static final double HAUTEUR_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getHauteur() <em>Hauteur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHauteur()
	 * @generated
	 * @ordered
	 */
	protected double hauteur = HAUTEUR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCouches() <em>Couches</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCouches()
	 * @generated
	 * @ordered
	 */
	protected EList<Couche> couches;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LayoutPackage.Literals.BOARD;
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
			eNotify(new ENotificationImpl(this, Notification.SET, LayoutPackage.BOARD__NOM, oldNom, nom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLargeur() {
		return largeur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLargeur(double newLargeur) {
		double oldLargeur = largeur;
		largeur = newLargeur;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayoutPackage.BOARD__LARGEUR, oldLargeur, largeur));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getHauteur() {
		return hauteur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHauteur(double newHauteur) {
		double oldHauteur = hauteur;
		hauteur = newHauteur;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LayoutPackage.BOARD__HAUTEUR, oldHauteur, hauteur));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Couche> getCouches() {
		if (couches == null) {
			couches = new EObjectContainmentEList<Couche>(Couche.class, this, LayoutPackage.BOARD__COUCHES);
		}
		return couches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LayoutPackage.BOARD__COUCHES:
				return ((InternalEList<?>)getCouches()).basicRemove(otherEnd, msgs);
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
			case LayoutPackage.BOARD__NOM:
				return getNom();
			case LayoutPackage.BOARD__LARGEUR:
				return getLargeur();
			case LayoutPackage.BOARD__HAUTEUR:
				return getHauteur();
			case LayoutPackage.BOARD__COUCHES:
				return getCouches();
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
			case LayoutPackage.BOARD__NOM:
				setNom((String)newValue);
				return;
			case LayoutPackage.BOARD__LARGEUR:
				setLargeur((Double)newValue);
				return;
			case LayoutPackage.BOARD__HAUTEUR:
				setHauteur((Double)newValue);
				return;
			case LayoutPackage.BOARD__COUCHES:
				getCouches().clear();
				getCouches().addAll((Collection<? extends Couche>)newValue);
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
			case LayoutPackage.BOARD__NOM:
				setNom(NOM_EDEFAULT);
				return;
			case LayoutPackage.BOARD__LARGEUR:
				setLargeur(LARGEUR_EDEFAULT);
				return;
			case LayoutPackage.BOARD__HAUTEUR:
				setHauteur(HAUTEUR_EDEFAULT);
				return;
			case LayoutPackage.BOARD__COUCHES:
				getCouches().clear();
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
			case LayoutPackage.BOARD__NOM:
				return NOM_EDEFAULT == null ? nom != null : !NOM_EDEFAULT.equals(nom);
			case LayoutPackage.BOARD__LARGEUR:
				return largeur != LARGEUR_EDEFAULT;
			case LayoutPackage.BOARD__HAUTEUR:
				return hauteur != HAUTEUR_EDEFAULT;
			case LayoutPackage.BOARD__COUCHES:
				return couches != null && !couches.isEmpty();
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
		result.append(", largeur: ");
		result.append(largeur);
		result.append(", hauteur: ");
		result.append(hauteur);
		result.append(')');
		return result.toString();
	}

} //BoardImpl
