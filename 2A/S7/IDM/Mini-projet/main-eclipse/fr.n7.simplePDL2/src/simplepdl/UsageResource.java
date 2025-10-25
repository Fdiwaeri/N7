/**
 */
package simplepdl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Usage Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link simplepdl.UsageResource#getUsageQuantity <em>Usage Quantity</em>}</li>
 *   <li>{@link simplepdl.UsageResource#getUsageTime <em>Usage Time</em>}</li>
 *   <li>{@link simplepdl.UsageResource#getWorkdefinition <em>Workdefinition</em>}</li>
 *   <li>{@link simplepdl.UsageResource#getResource <em>Resource</em>}</li>
 * </ul>
 *
 * @see simplepdl.SimplepdlPackage#getUsageResource()
 * @model
 * @generated
 */
public interface UsageResource extends EObject {
	/**
	 * Returns the value of the '<em><b>Usage Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage Quantity</em>' attribute.
	 * @see #setUsageQuantity(int)
	 * @see simplepdl.SimplepdlPackage#getUsageResource_UsageQuantity()
	 * @model
	 * @generated
	 */
	int getUsageQuantity();

	/**
	 * Sets the value of the '{@link simplepdl.UsageResource#getUsageQuantity <em>Usage Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage Quantity</em>' attribute.
	 * @see #getUsageQuantity()
	 * @generated
	 */
	void setUsageQuantity(int value);

	/**
	 * Returns the value of the '<em><b>Usage Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage Time</em>' attribute.
	 * @see #setUsageTime(int)
	 * @see simplepdl.SimplepdlPackage#getUsageResource_UsageTime()
	 * @model
	 * @generated
	 */
	int getUsageTime();

	/**
	 * Sets the value of the '{@link simplepdl.UsageResource#getUsageTime <em>Usage Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage Time</em>' attribute.
	 * @see #getUsageTime()
	 * @generated
	 */
	void setUsageTime(int value);

	/**
	 * Returns the value of the '<em><b>Workdefinition</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link simplepdl.WorkDefinition#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Workdefinition</em>' container reference.
	 * @see #setWorkdefinition(WorkDefinition)
	 * @see simplepdl.SimplepdlPackage#getUsageResource_Workdefinition()
	 * @see simplepdl.WorkDefinition#getUses
	 * @model opposite="uses" required="true" transient="false"
	 * @generated
	 */
	WorkDefinition getWorkdefinition();

	/**
	 * Sets the value of the '{@link simplepdl.UsageResource#getWorkdefinition <em>Workdefinition</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Workdefinition</em>' container reference.
	 * @see #getWorkdefinition()
	 * @generated
	 */
	void setWorkdefinition(WorkDefinition value);

	/**
	 * Returns the value of the '<em><b>Resource</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link simplepdl.Resource#getUsageresources <em>Usageresources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' reference.
	 * @see #setResource(Resource)
	 * @see simplepdl.SimplepdlPackage#getUsageResource_Resource()
	 * @see simplepdl.Resource#getUsageresources
	 * @model opposite="usageresources" required="true"
	 * @generated
	 */
	Resource getResource();

	/**
	 * Sets the value of the '{@link simplepdl.UsageResource#getResource <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(Resource value);

} // UsageResource
