/**
 */
package layout;

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
 * @see layout.LayoutFactory
 * @model kind="package"
 * @generated
 */
public interface LayoutPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "layout";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/layout";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "layout";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LayoutPackage eINSTANCE = layout.impl.LayoutPackageImpl.init();

	/**
	 * The meta object id for the '{@link layout.impl.LayoutImpl <em>Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see layout.impl.LayoutImpl
	 * @see layout.impl.LayoutPackageImpl#getLayout()
	 * @generated
	 */
	int LAYOUT = 0;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__NOM = 0;

	/**
	 * The feature id for the '<em><b>Boards</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__BOARDS = 1;

	/**
	 * The feature id for the '<em><b>Circuit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__CIRCUIT = 2;

	/**
	 * The number of structural features of the '<em>Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link layout.impl.BoardImpl <em>Board</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see layout.impl.BoardImpl
	 * @see layout.impl.LayoutPackageImpl#getBoard()
	 * @generated
	 */
	int BOARD = 1;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD__NOM = 0;

	/**
	 * The feature id for the '<em><b>Largeur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD__LARGEUR = 1;

	/**
	 * The feature id for the '<em><b>Hauteur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD__HAUTEUR = 2;

	/**
	 * The feature id for the '<em><b>Couches</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD__COUCHES = 3;

	/**
	 * The number of structural features of the '<em>Board</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Board</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link layout.impl.CoucheImpl <em>Couche</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see layout.impl.CoucheImpl
	 * @see layout.impl.LayoutPackageImpl#getCouche()
	 * @generated
	 */
	int COUCHE = 2;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHE__NOM = 0;

	/**
	 * The feature id for the '<em><b>Numero</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHE__NUMERO = 1;

	/**
	 * The feature id for the '<em><b>Pistes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHE__PISTES = 2;

	/**
	 * The number of structural features of the '<em>Couche</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Couche</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link layout.impl.CoucheExterneImpl <em>Couche Externe</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see layout.impl.CoucheExterneImpl
	 * @see layout.impl.LayoutPackageImpl#getCoucheExterne()
	 * @generated
	 */
	int COUCHE_EXTERNE = 3;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHE_EXTERNE__NOM = COUCHE__NOM;

	/**
	 * The feature id for the '<em><b>Numero</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHE_EXTERNE__NUMERO = COUCHE__NUMERO;

	/**
	 * The feature id for the '<em><b>Pistes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHE_EXTERNE__PISTES = COUCHE__PISTES;

	/**
	 * The feature id for the '<em><b>Composants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHE_EXTERNE__COMPOSANTS = COUCHE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Couche Externe</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHE_EXTERNE_FEATURE_COUNT = COUCHE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Couche Externe</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHE_EXTERNE_OPERATION_COUNT = COUCHE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link layout.impl.CoucheInterneImpl <em>Couche Interne</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see layout.impl.CoucheInterneImpl
	 * @see layout.impl.LayoutPackageImpl#getCoucheInterne()
	 * @generated
	 */
	int COUCHE_INTERNE = 4;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHE_INTERNE__NOM = COUCHE__NOM;

	/**
	 * The feature id for the '<em><b>Numero</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHE_INTERNE__NUMERO = COUCHE__NUMERO;

	/**
	 * The feature id for the '<em><b>Pistes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHE_INTERNE__PISTES = COUCHE__PISTES;

	/**
	 * The number of structural features of the '<em>Couche Interne</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHE_INTERNE_FEATURE_COUNT = COUCHE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Couche Interne</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHE_INTERNE_OPERATION_COUNT = COUCHE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link layout.impl.ComposantPositionImpl <em>Composant Position</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see layout.impl.ComposantPositionImpl
	 * @see layout.impl.LayoutPackageImpl#getComposantPosition()
	 * @generated
	 */
	int COMPOSANT_POSITION = 5;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSANT_POSITION__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSANT_POSITION__Y = 1;

	/**
	 * The feature id for the '<em><b>Rotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSANT_POSITION__ROTATION = 2;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSANT_POSITION__INSTANCE = 3;

	/**
	 * The number of structural features of the '<em>Composant Position</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSANT_POSITION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Composant Position</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSANT_POSITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link layout.impl.PisteImpl <em>Piste</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see layout.impl.PisteImpl
	 * @see layout.impl.LayoutPackageImpl#getPiste()
	 * @generated
	 */
	int PISTE = 6;

	/**
	 * The feature id for the '<em><b>Nom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PISTE__NOM = 0;

	/**
	 * The feature id for the '<em><b>Largeur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PISTE__LARGEUR = 1;

	/**
	 * The feature id for the '<em><b>Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PISTE__POINTS = 2;

	/**
	 * The feature id for the '<em><b>Connexion</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PISTE__CONNEXION = 3;

	/**
	 * The number of structural features of the '<em>Piste</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PISTE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Piste</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PISTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link layout.impl.PointImpl <em>Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see layout.impl.PointImpl
	 * @see layout.impl.LayoutPackageImpl#getPoint()
	 * @generated
	 */
	int POINT = 7;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__Y = 1;

	/**
	 * The number of structural features of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link layout.Layout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layout</em>'.
	 * @see layout.Layout
	 * @generated
	 */
	EClass getLayout();

	/**
	 * Returns the meta object for the attribute '{@link layout.Layout#getNom <em>Nom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nom</em>'.
	 * @see layout.Layout#getNom()
	 * @see #getLayout()
	 * @generated
	 */
	EAttribute getLayout_Nom();

	/**
	 * Returns the meta object for the containment reference list '{@link layout.Layout#getBoards <em>Boards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Boards</em>'.
	 * @see layout.Layout#getBoards()
	 * @see #getLayout()
	 * @generated
	 */
	EReference getLayout_Boards();

	/**
	 * Returns the meta object for the reference '{@link layout.Layout#getCircuit <em>Circuit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Circuit</em>'.
	 * @see layout.Layout#getCircuit()
	 * @see #getLayout()
	 * @generated
	 */
	EReference getLayout_Circuit();

	/**
	 * Returns the meta object for class '{@link layout.Board <em>Board</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Board</em>'.
	 * @see layout.Board
	 * @generated
	 */
	EClass getBoard();

	/**
	 * Returns the meta object for the attribute '{@link layout.Board#getNom <em>Nom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nom</em>'.
	 * @see layout.Board#getNom()
	 * @see #getBoard()
	 * @generated
	 */
	EAttribute getBoard_Nom();

	/**
	 * Returns the meta object for the attribute '{@link layout.Board#getLargeur <em>Largeur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Largeur</em>'.
	 * @see layout.Board#getLargeur()
	 * @see #getBoard()
	 * @generated
	 */
	EAttribute getBoard_Largeur();

	/**
	 * Returns the meta object for the attribute '{@link layout.Board#getHauteur <em>Hauteur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hauteur</em>'.
	 * @see layout.Board#getHauteur()
	 * @see #getBoard()
	 * @generated
	 */
	EAttribute getBoard_Hauteur();

	/**
	 * Returns the meta object for the containment reference list '{@link layout.Board#getCouches <em>Couches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Couches</em>'.
	 * @see layout.Board#getCouches()
	 * @see #getBoard()
	 * @generated
	 */
	EReference getBoard_Couches();

	/**
	 * Returns the meta object for class '{@link layout.Couche <em>Couche</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Couche</em>'.
	 * @see layout.Couche
	 * @generated
	 */
	EClass getCouche();

	/**
	 * Returns the meta object for the attribute '{@link layout.Couche#getNom <em>Nom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nom</em>'.
	 * @see layout.Couche#getNom()
	 * @see #getCouche()
	 * @generated
	 */
	EAttribute getCouche_Nom();

	/**
	 * Returns the meta object for the attribute '{@link layout.Couche#getNumero <em>Numero</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Numero</em>'.
	 * @see layout.Couche#getNumero()
	 * @see #getCouche()
	 * @generated
	 */
	EAttribute getCouche_Numero();

	/**
	 * Returns the meta object for the containment reference list '{@link layout.Couche#getPistes <em>Pistes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pistes</em>'.
	 * @see layout.Couche#getPistes()
	 * @see #getCouche()
	 * @generated
	 */
	EReference getCouche_Pistes();

	/**
	 * Returns the meta object for class '{@link layout.CoucheExterne <em>Couche Externe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Couche Externe</em>'.
	 * @see layout.CoucheExterne
	 * @generated
	 */
	EClass getCoucheExterne();

	/**
	 * Returns the meta object for the containment reference list '{@link layout.CoucheExterne#getComposants <em>Composants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Composants</em>'.
	 * @see layout.CoucheExterne#getComposants()
	 * @see #getCoucheExterne()
	 * @generated
	 */
	EReference getCoucheExterne_Composants();

	/**
	 * Returns the meta object for class '{@link layout.CoucheInterne <em>Couche Interne</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Couche Interne</em>'.
	 * @see layout.CoucheInterne
	 * @generated
	 */
	EClass getCoucheInterne();

	/**
	 * Returns the meta object for class '{@link layout.ComposantPosition <em>Composant Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composant Position</em>'.
	 * @see layout.ComposantPosition
	 * @generated
	 */
	EClass getComposantPosition();

	/**
	 * Returns the meta object for the attribute '{@link layout.ComposantPosition#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see layout.ComposantPosition#getX()
	 * @see #getComposantPosition()
	 * @generated
	 */
	EAttribute getComposantPosition_X();

	/**
	 * Returns the meta object for the attribute '{@link layout.ComposantPosition#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see layout.ComposantPosition#getY()
	 * @see #getComposantPosition()
	 * @generated
	 */
	EAttribute getComposantPosition_Y();

	/**
	 * Returns the meta object for the attribute '{@link layout.ComposantPosition#getRotation <em>Rotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rotation</em>'.
	 * @see layout.ComposantPosition#getRotation()
	 * @see #getComposantPosition()
	 * @generated
	 */
	EAttribute getComposantPosition_Rotation();

	/**
	 * Returns the meta object for the reference '{@link layout.ComposantPosition#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance</em>'.
	 * @see layout.ComposantPosition#getInstance()
	 * @see #getComposantPosition()
	 * @generated
	 */
	EReference getComposantPosition_Instance();

	/**
	 * Returns the meta object for class '{@link layout.Piste <em>Piste</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Piste</em>'.
	 * @see layout.Piste
	 * @generated
	 */
	EClass getPiste();

	/**
	 * Returns the meta object for the attribute '{@link layout.Piste#getNom <em>Nom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nom</em>'.
	 * @see layout.Piste#getNom()
	 * @see #getPiste()
	 * @generated
	 */
	EAttribute getPiste_Nom();

	/**
	 * Returns the meta object for the attribute '{@link layout.Piste#getLargeur <em>Largeur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Largeur</em>'.
	 * @see layout.Piste#getLargeur()
	 * @see #getPiste()
	 * @generated
	 */
	EAttribute getPiste_Largeur();

	/**
	 * Returns the meta object for the containment reference list '{@link layout.Piste#getPoints <em>Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Points</em>'.
	 * @see layout.Piste#getPoints()
	 * @see #getPiste()
	 * @generated
	 */
	EReference getPiste_Points();

	/**
	 * Returns the meta object for the reference '{@link layout.Piste#getConnexion <em>Connexion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connexion</em>'.
	 * @see layout.Piste#getConnexion()
	 * @see #getPiste()
	 * @generated
	 */
	EReference getPiste_Connexion();

	/**
	 * Returns the meta object for class '{@link layout.Point <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point</em>'.
	 * @see layout.Point
	 * @generated
	 */
	EClass getPoint();

	/**
	 * Returns the meta object for the attribute '{@link layout.Point#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see layout.Point#getX()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_X();

	/**
	 * Returns the meta object for the attribute '{@link layout.Point#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see layout.Point#getY()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_Y();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LayoutFactory getLayoutFactory();

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
		 * The meta object literal for the '{@link layout.impl.LayoutImpl <em>Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see layout.impl.LayoutImpl
		 * @see layout.impl.LayoutPackageImpl#getLayout()
		 * @generated
		 */
		EClass LAYOUT = eINSTANCE.getLayout();

		/**
		 * The meta object literal for the '<em><b>Nom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYOUT__NOM = eINSTANCE.getLayout_Nom();

		/**
		 * The meta object literal for the '<em><b>Boards</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYOUT__BOARDS = eINSTANCE.getLayout_Boards();

		/**
		 * The meta object literal for the '<em><b>Circuit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYOUT__CIRCUIT = eINSTANCE.getLayout_Circuit();

		/**
		 * The meta object literal for the '{@link layout.impl.BoardImpl <em>Board</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see layout.impl.BoardImpl
		 * @see layout.impl.LayoutPackageImpl#getBoard()
		 * @generated
		 */
		EClass BOARD = eINSTANCE.getBoard();

		/**
		 * The meta object literal for the '<em><b>Nom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOARD__NOM = eINSTANCE.getBoard_Nom();

		/**
		 * The meta object literal for the '<em><b>Largeur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOARD__LARGEUR = eINSTANCE.getBoard_Largeur();

		/**
		 * The meta object literal for the '<em><b>Hauteur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOARD__HAUTEUR = eINSTANCE.getBoard_Hauteur();

		/**
		 * The meta object literal for the '<em><b>Couches</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOARD__COUCHES = eINSTANCE.getBoard_Couches();

		/**
		 * The meta object literal for the '{@link layout.impl.CoucheImpl <em>Couche</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see layout.impl.CoucheImpl
		 * @see layout.impl.LayoutPackageImpl#getCouche()
		 * @generated
		 */
		EClass COUCHE = eINSTANCE.getCouche();

		/**
		 * The meta object literal for the '<em><b>Nom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COUCHE__NOM = eINSTANCE.getCouche_Nom();

		/**
		 * The meta object literal for the '<em><b>Numero</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COUCHE__NUMERO = eINSTANCE.getCouche_Numero();

		/**
		 * The meta object literal for the '<em><b>Pistes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COUCHE__PISTES = eINSTANCE.getCouche_Pistes();

		/**
		 * The meta object literal for the '{@link layout.impl.CoucheExterneImpl <em>Couche Externe</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see layout.impl.CoucheExterneImpl
		 * @see layout.impl.LayoutPackageImpl#getCoucheExterne()
		 * @generated
		 */
		EClass COUCHE_EXTERNE = eINSTANCE.getCoucheExterne();

		/**
		 * The meta object literal for the '<em><b>Composants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COUCHE_EXTERNE__COMPOSANTS = eINSTANCE.getCoucheExterne_Composants();

		/**
		 * The meta object literal for the '{@link layout.impl.CoucheInterneImpl <em>Couche Interne</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see layout.impl.CoucheInterneImpl
		 * @see layout.impl.LayoutPackageImpl#getCoucheInterne()
		 * @generated
		 */
		EClass COUCHE_INTERNE = eINSTANCE.getCoucheInterne();

		/**
		 * The meta object literal for the '{@link layout.impl.ComposantPositionImpl <em>Composant Position</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see layout.impl.ComposantPositionImpl
		 * @see layout.impl.LayoutPackageImpl#getComposantPosition()
		 * @generated
		 */
		EClass COMPOSANT_POSITION = eINSTANCE.getComposantPosition();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSANT_POSITION__X = eINSTANCE.getComposantPosition_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSANT_POSITION__Y = eINSTANCE.getComposantPosition_Y();

		/**
		 * The meta object literal for the '<em><b>Rotation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSANT_POSITION__ROTATION = eINSTANCE.getComposantPosition_Rotation();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSANT_POSITION__INSTANCE = eINSTANCE.getComposantPosition_Instance();

		/**
		 * The meta object literal for the '{@link layout.impl.PisteImpl <em>Piste</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see layout.impl.PisteImpl
		 * @see layout.impl.LayoutPackageImpl#getPiste()
		 * @generated
		 */
		EClass PISTE = eINSTANCE.getPiste();

		/**
		 * The meta object literal for the '<em><b>Nom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PISTE__NOM = eINSTANCE.getPiste_Nom();

		/**
		 * The meta object literal for the '<em><b>Largeur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PISTE__LARGEUR = eINSTANCE.getPiste_Largeur();

		/**
		 * The meta object literal for the '<em><b>Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PISTE__POINTS = eINSTANCE.getPiste_Points();

		/**
		 * The meta object literal for the '<em><b>Connexion</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PISTE__CONNEXION = eINSTANCE.getPiste_Connexion();

		/**
		 * The meta object literal for the '{@link layout.impl.PointImpl <em>Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see layout.impl.PointImpl
		 * @see layout.impl.LayoutPackageImpl#getPoint()
		 * @generated
		 */
		EClass POINT = eINSTANCE.getPoint();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT__X = eINSTANCE.getPoint_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT__Y = eINSTANCE.getPoint_Y();

	}

} //LayoutPackage
