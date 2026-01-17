/**
 */
package netlist;

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
 * @see netlist.NetlistFactory
 * @model kind="package"
 * @generated
 */
public interface NetlistPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "netlist";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/netlist";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "netlist";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NetlistPackage eINSTANCE = netlist.impl.NetlistPackageImpl.init();

	/**
	 * The meta object id for the '{@link netlist.impl.CircuitImpl <em>Circuit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see netlist.impl.CircuitImpl
	 * @see netlist.impl.NetlistPackageImpl#getCircuit()
	 * @generated
	 */
	int CIRCUIT = 0;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIRCUIT__NOM = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIRCUIT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Catalogue</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIRCUIT__CATALOGUE = 2;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIRCUIT__INSTANCES = 3;

	/**
	 * The feature id for the '<em><b>Connexions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIRCUIT__CONNEXIONS = 4;

	/**
	 * The feature id for the '<em><b>Commentaires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIRCUIT__COMMENTAIRES = 5;

	/**
	 * The number of structural features of the '<em>Circuit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIRCUIT_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Circuit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIRCUIT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link netlist.impl.InstanceComposantImpl <em>Instance Composant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see netlist.impl.InstanceComposantImpl
	 * @see netlist.impl.NetlistPackageImpl#getInstanceComposant()
	 * @generated
	 */
	int INSTANCE_COMPOSANT = 1;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_COMPOSANT__NOM = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_COMPOSANT__ID = 1;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_COMPOSANT__DEFINITION = 2;

	/**
	 * The number of structural features of the '<em>Instance Composant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_COMPOSANT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Instance Composant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_COMPOSANT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link netlist.impl.ConnexionImpl <em>Connexion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see netlist.impl.ConnexionImpl
	 * @see netlist.impl.NetlistPackageImpl#getConnexion()
	 * @generated
	 */
	int CONNEXION = 2;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNEXION__NOM = 0;

	/**
	 * The feature id for the '<em><b>Connextions Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNEXION__CONNEXTIONS_PORT = 1;

	/**
	 * The number of structural features of the '<em>Connexion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNEXION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Connexion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNEXION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link netlist.impl.ConnexionPortImpl <em>Connexion Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see netlist.impl.ConnexionPortImpl
	 * @see netlist.impl.NetlistPackageImpl#getConnexionPort()
	 * @generated
	 */
	int CONNEXION_PORT = 3;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNEXION_PORT__PORT = 0;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNEXION_PORT__INSTANCE = 1;

	/**
	 * The number of structural features of the '<em>Connexion Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNEXION_PORT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Connexion Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNEXION_PORT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link netlist.impl.CommentaireImpl <em>Commentaire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see netlist.impl.CommentaireImpl
	 * @see netlist.impl.NetlistPackageImpl#getCommentaire()
	 * @generated
	 */
	int COMMENTAIRE = 4;

	/**
	 * The feature id for the '<em><b>Texte</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENTAIRE__TEXTE = 0;

	/**
	 * The feature id for the '<em><b>Auteur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENTAIRE__AUTEUR = 1;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENTAIRE__DATE = 2;

	/**
	 * The number of structural features of the '<em>Commentaire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENTAIRE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Commentaire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENTAIRE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link netlist.Circuit <em>Circuit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Circuit</em>'.
	 * @see netlist.Circuit
	 * @generated
	 */
	EClass getCircuit();

	/**
	 * Returns the meta object for the attribute '{@link netlist.Circuit#getNom <em>Nom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nom</em>'.
	 * @see netlist.Circuit#getNom()
	 * @see #getCircuit()
	 * @generated
	 */
	EAttribute getCircuit_Nom();

	/**
	 * Returns the meta object for the attribute '{@link netlist.Circuit#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see netlist.Circuit#getDescription()
	 * @see #getCircuit()
	 * @generated
	 */
	EAttribute getCircuit_Description();

	/**
	 * Returns the meta object for the reference '{@link netlist.Circuit#getCatalogue <em>Catalogue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Catalogue</em>'.
	 * @see netlist.Circuit#getCatalogue()
	 * @see #getCircuit()
	 * @generated
	 */
	EReference getCircuit_Catalogue();

	/**
	 * Returns the meta object for the containment reference list '{@link netlist.Circuit#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instances</em>'.
	 * @see netlist.Circuit#getInstances()
	 * @see #getCircuit()
	 * @generated
	 */
	EReference getCircuit_Instances();

	/**
	 * Returns the meta object for the containment reference list '{@link netlist.Circuit#getConnexions <em>Connexions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connexions</em>'.
	 * @see netlist.Circuit#getConnexions()
	 * @see #getCircuit()
	 * @generated
	 */
	EReference getCircuit_Connexions();

	/**
	 * Returns the meta object for the containment reference list '{@link netlist.Circuit#getCommentaires <em>Commentaires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Commentaires</em>'.
	 * @see netlist.Circuit#getCommentaires()
	 * @see #getCircuit()
	 * @generated
	 */
	EReference getCircuit_Commentaires();

	/**
	 * Returns the meta object for class '{@link netlist.InstanceComposant <em>Instance Composant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Composant</em>'.
	 * @see netlist.InstanceComposant
	 * @generated
	 */
	EClass getInstanceComposant();

	/**
	 * Returns the meta object for the attribute '{@link netlist.InstanceComposant#getNom <em>Nom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nom</em>'.
	 * @see netlist.InstanceComposant#getNom()
	 * @see #getInstanceComposant()
	 * @generated
	 */
	EAttribute getInstanceComposant_Nom();

	/**
	 * Returns the meta object for the attribute '{@link netlist.InstanceComposant#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see netlist.InstanceComposant#getId()
	 * @see #getInstanceComposant()
	 * @generated
	 */
	EAttribute getInstanceComposant_Id();

	/**
	 * Returns the meta object for the reference '{@link netlist.InstanceComposant#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see netlist.InstanceComposant#getDefinition()
	 * @see #getInstanceComposant()
	 * @generated
	 */
	EReference getInstanceComposant_Definition();

	/**
	 * Returns the meta object for class '{@link netlist.Connexion <em>Connexion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connexion</em>'.
	 * @see netlist.Connexion
	 * @generated
	 */
	EClass getConnexion();

	/**
	 * Returns the meta object for the attribute '{@link netlist.Connexion#getNom <em>Nom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nom</em>'.
	 * @see netlist.Connexion#getNom()
	 * @see #getConnexion()
	 * @generated
	 */
	EAttribute getConnexion_Nom();

	/**
	 * Returns the meta object for the containment reference list '{@link netlist.Connexion#getConnextionsPort <em>Connextions Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connextions Port</em>'.
	 * @see netlist.Connexion#getConnextionsPort()
	 * @see #getConnexion()
	 * @generated
	 */
	EReference getConnexion_ConnextionsPort();

	/**
	 * Returns the meta object for class '{@link netlist.ConnexionPort <em>Connexion Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connexion Port</em>'.
	 * @see netlist.ConnexionPort
	 * @generated
	 */
	EClass getConnexionPort();

	/**
	 * Returns the meta object for the reference '{@link netlist.ConnexionPort#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see netlist.ConnexionPort#getPort()
	 * @see #getConnexionPort()
	 * @generated
	 */
	EReference getConnexionPort_Port();

	/**
	 * Returns the meta object for the reference '{@link netlist.ConnexionPort#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance</em>'.
	 * @see netlist.ConnexionPort#getInstance()
	 * @see #getConnexionPort()
	 * @generated
	 */
	EReference getConnexionPort_Instance();

	/**
	 * Returns the meta object for class '{@link netlist.Commentaire <em>Commentaire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Commentaire</em>'.
	 * @see netlist.Commentaire
	 * @generated
	 */
	EClass getCommentaire();

	/**
	 * Returns the meta object for the attribute '{@link netlist.Commentaire#getTexte <em>Texte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Texte</em>'.
	 * @see netlist.Commentaire#getTexte()
	 * @see #getCommentaire()
	 * @generated
	 */
	EAttribute getCommentaire_Texte();

	/**
	 * Returns the meta object for the attribute '{@link netlist.Commentaire#getAuteur <em>Auteur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auteur</em>'.
	 * @see netlist.Commentaire#getAuteur()
	 * @see #getCommentaire()
	 * @generated
	 */
	EAttribute getCommentaire_Auteur();

	/**
	 * Returns the meta object for the attribute '{@link netlist.Commentaire#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see netlist.Commentaire#getDate()
	 * @see #getCommentaire()
	 * @generated
	 */
	EAttribute getCommentaire_Date();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NetlistFactory getNetlistFactory();

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
		 * The meta object literal for the '{@link netlist.impl.CircuitImpl <em>Circuit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see netlist.impl.CircuitImpl
		 * @see netlist.impl.NetlistPackageImpl#getCircuit()
		 * @generated
		 */
		EClass CIRCUIT = eINSTANCE.getCircuit();

		/**
		 * The meta object literal for the '<em><b>Nom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CIRCUIT__NOM = eINSTANCE.getCircuit_Nom();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CIRCUIT__DESCRIPTION = eINSTANCE.getCircuit_Description();

		/**
		 * The meta object literal for the '<em><b>Catalogue</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CIRCUIT__CATALOGUE = eINSTANCE.getCircuit_Catalogue();

		/**
		 * The meta object literal for the '<em><b>Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CIRCUIT__INSTANCES = eINSTANCE.getCircuit_Instances();

		/**
		 * The meta object literal for the '<em><b>Connexions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CIRCUIT__CONNEXIONS = eINSTANCE.getCircuit_Connexions();

		/**
		 * The meta object literal for the '<em><b>Commentaires</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CIRCUIT__COMMENTAIRES = eINSTANCE.getCircuit_Commentaires();

		/**
		 * The meta object literal for the '{@link netlist.impl.InstanceComposantImpl <em>Instance Composant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see netlist.impl.InstanceComposantImpl
		 * @see netlist.impl.NetlistPackageImpl#getInstanceComposant()
		 * @generated
		 */
		EClass INSTANCE_COMPOSANT = eINSTANCE.getInstanceComposant();

		/**
		 * The meta object literal for the '<em><b>Nom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_COMPOSANT__NOM = eINSTANCE.getInstanceComposant_Nom();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_COMPOSANT__ID = eINSTANCE.getInstanceComposant_Id();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_COMPOSANT__DEFINITION = eINSTANCE.getInstanceComposant_Definition();

		/**
		 * The meta object literal for the '{@link netlist.impl.ConnexionImpl <em>Connexion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see netlist.impl.ConnexionImpl
		 * @see netlist.impl.NetlistPackageImpl#getConnexion()
		 * @generated
		 */
		EClass CONNEXION = eINSTANCE.getConnexion();

		/**
		 * The meta object literal for the '<em><b>Nom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNEXION__NOM = eINSTANCE.getConnexion_Nom();

		/**
		 * The meta object literal for the '<em><b>Connextions Port</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNEXION__CONNEXTIONS_PORT = eINSTANCE.getConnexion_ConnextionsPort();

		/**
		 * The meta object literal for the '{@link netlist.impl.ConnexionPortImpl <em>Connexion Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see netlist.impl.ConnexionPortImpl
		 * @see netlist.impl.NetlistPackageImpl#getConnexionPort()
		 * @generated
		 */
		EClass CONNEXION_PORT = eINSTANCE.getConnexionPort();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNEXION_PORT__PORT = eINSTANCE.getConnexionPort_Port();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNEXION_PORT__INSTANCE = eINSTANCE.getConnexionPort_Instance();

		/**
		 * The meta object literal for the '{@link netlist.impl.CommentaireImpl <em>Commentaire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see netlist.impl.CommentaireImpl
		 * @see netlist.impl.NetlistPackageImpl#getCommentaire()
		 * @generated
		 */
		EClass COMMENTAIRE = eINSTANCE.getCommentaire();

		/**
		 * The meta object literal for the '<em><b>Texte</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMENTAIRE__TEXTE = eINSTANCE.getCommentaire_Texte();

		/**
		 * The meta object literal for the '<em><b>Auteur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMENTAIRE__AUTEUR = eINSTANCE.getCommentaire_Auteur();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMENTAIRE__DATE = eINSTANCE.getCommentaire_Date();

	}

} //NetlistPackage
