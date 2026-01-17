/**
 */
package netlist.impl;

import netlist.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NetlistFactoryImpl extends EFactoryImpl implements NetlistFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NetlistFactory init() {
		try {
			NetlistFactory theNetlistFactory = (NetlistFactory)EPackage.Registry.INSTANCE.getEFactory(NetlistPackage.eNS_URI);
			if (theNetlistFactory != null) {
				return theNetlistFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NetlistFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetlistFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case NetlistPackage.CIRCUIT: return createCircuit();
			case NetlistPackage.INSTANCE_COMPOSANT: return createInstanceComposant();
			case NetlistPackage.CONNEXION: return createConnexion();
			case NetlistPackage.CONNEXION_PORT: return createConnexionPort();
			case NetlistPackage.COMMENTAIRE: return createCommentaire();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Circuit createCircuit() {
		CircuitImpl circuit = new CircuitImpl();
		return circuit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InstanceComposant createInstanceComposant() {
		InstanceComposantImpl instanceComposant = new InstanceComposantImpl();
		return instanceComposant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Connexion createConnexion() {
		ConnexionImpl connexion = new ConnexionImpl();
		return connexion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnexionPort createConnexionPort() {
		ConnexionPortImpl connexionPort = new ConnexionPortImpl();
		return connexionPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Commentaire createCommentaire() {
		CommentaireImpl commentaire = new CommentaireImpl();
		return commentaire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NetlistPackage getNetlistPackage() {
		return (NetlistPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NetlistPackage getPackage() {
		return NetlistPackage.eINSTANCE;
	}

} //NetlistFactoryImpl
