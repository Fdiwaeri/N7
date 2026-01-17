/**
 */
package fr.n7.idm.catalogue.util;

import fr.n7.idm.catalogue.*;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic; // <--- IMPORT IMPORTANT AJOUTÉ
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * The <b>Validator</b> for the model.
 * @see fr.n7.idm.catalogue.CataloguePackage
 * @generated
 */
public class CatalogueValidator extends EObjectValidator {
    public static final CatalogueValidator INSTANCE = new CatalogueValidator();
    public static final String DIAGNOSTIC_SOURCE = "fr.n7.idm.catalogue";
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    public CatalogueValidator() {
        super();
    }

    @Override
    protected EPackage getEPackage() {
        return CataloguePackage.eINSTANCE;
    }

    @Override
    protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        switch (classifierID) {
        case CataloguePackage.CATALOGUE:
            return validateCatalogue((Catalogue) value, diagnostics, context);
        case CataloguePackage.COMPOSANT:
            return validateComposant((Composant) value, diagnostics, context);
        case CataloguePackage.PORT:
            return validatePort((Port) value, diagnostics, context);
        case CataloguePackage.EMPREINTE:
            return validateEmpreinte((Empreinte) value, diagnostics, context);
        case CataloguePackage.POSITION_PORT:
            return validatePositionPort((PositionPort) value, diagnostics, context);
        case CataloguePackage.CONTRAINTE:
            return validateContrainte((Contrainte) value, diagnostics, context);
        case CataloguePackage.CONTRAINTE_LOGIQUE:
            return validateContrainteLogique((ContrainteLogique) value, diagnostics, context);
        case CataloguePackage.CONTRAINTE_ET:
            return validateContrainteEt((ContrainteEt) value, diagnostics, context);
        case CataloguePackage.CONTRAINTE_OU:
            return validateContrainteOu((ContrainteOu) value, diagnostics, context);
        case CataloguePackage.CONTRAINTE_NON:
            return validateContrainteNon((ContrainteNon) value, diagnostics, context);
        case CataloguePackage.CONTRAINTE_GEOMETRIQUE:
            return validateContrainteGeometrique((ContrainteGeometrique) value, diagnostics, context);
        case CataloguePackage.CONTRAINTE_REDONDANCE:
            return validateContrainteRedondance((ContrainteRedondance) value, diagnostics, context);
        default:
            return true;
        }
    }

    public boolean validateCatalogue(Catalogue catalogue, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(catalogue, diagnostics, context);
    }

    public boolean validateComposant(Composant composant, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(composant, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms(composant, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms(composant, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained(composant, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryBidirectionalReferenceIsPaired(composant, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves(composant, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID(composant, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique(composant, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique(composant, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateComposant_nomValide(composant, diagnostics, context);
        return result;
    }

    /**
     * IMPLÉMENTATION PERSONNALISÉE : Vérifie que le nom n'est pas vide.
     * @generated NOT
     */
    public boolean validateComposant_nomValide(Composant composant, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        
        // Règle JAVA : Le nom ne doit pas être vide ou null
        if (composant.getNom() == null || composant.getNom().trim().length() == 0) {
            if (diagnostics != null) {
                // CORRECTION : Utilisation de new BasicDiagnostic
                diagnostics.add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        DIAGNOSTIC_SOURCE,
                        0,
                        "ERREUR : Le composant doit avoir un nom !",
                        new Object[] { composant }
                ));
            }
            return false;
        }
        return true;
    }

    public boolean validatePort(Port port, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(port, diagnostics, context);
    }

    public boolean validateEmpreinte(Empreinte empreinte, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(empreinte, diagnostics, context);
    }

    public boolean validatePositionPort(PositionPort positionPort, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(positionPort, diagnostics, context);
    }

    public boolean validateContrainte(Contrainte contrainte, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(contrainte, diagnostics, context);
    }

    public boolean validateContrainteLogique(ContrainteLogique contrainteLogique, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(contrainteLogique, diagnostics, context);
    }

    public boolean validateContrainteEt(ContrainteEt contrainteEt, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(contrainteEt, diagnostics, context);
    }

    public boolean validateContrainteOu(ContrainteOu contrainteOu, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(contrainteOu, diagnostics, context);
    }

    public boolean validateContrainteNon(ContrainteNon contrainteNon, DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(contrainteNon, diagnostics, context);
    }

    public boolean validateContrainteGeometrique(ContrainteGeometrique contrainteGeometrique,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_NoCircularContainment(contrainteGeometrique, diagnostics, context))
            return false;
        boolean result = validate_EveryMultiplicityConforms(contrainteGeometrique, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms(contrainteGeometrique, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained(contrainteGeometrique, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryBidirectionalReferenceIsPaired(contrainteGeometrique, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves(contrainteGeometrique, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID(contrainteGeometrique, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique(contrainteGeometrique, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique(contrainteGeometrique, diagnostics, context);
        if (result || diagnostics != null)
            result &= validateContrainteGeometrique_distanceValide(contrainteGeometrique, diagnostics, context);
        return result;
    }

    /**
     * IMPLÉMENTATION PERSONNALISÉE : Vérifie Min >= 0 et Max > Min.
     * @generated NOT
     */
    public boolean validateContrainteGeometrique_distanceValide(ContrainteGeometrique contrainteGeometrique,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
        
        // Règle 1 : La distance Min ne peut pas être négative
        if (contrainteGeometrique.getDistanceMin() < 0) {
            if (diagnostics != null) {
                // CORRECTION : Utilisation de new BasicDiagnostic
                diagnostics.add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        DIAGNOSTIC_SOURCE,
                        0,
                        "ERREUR : La distance minimale ne peut pas être négative.",
                        new Object[] { contrainteGeometrique }
                ));
            }
            return false;
        }

        // Règle 2 : La distance Max ne peut pas être négative
        if (contrainteGeometrique.getDistanceMax() < 0) {
             if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        DIAGNOSTIC_SOURCE,
                        0,
                        "ERREUR : La distance maximale ne peut pas être négative (" + contrainteGeometrique.getDistanceMax() + ").",
                        new Object[] { contrainteGeometrique }
                ));
            }
            return false;
        }

        // Règle 3 : Cohérence Min/Max
        if (contrainteGeometrique.getDistanceMax() > 0 && contrainteGeometrique.getDistanceMax() < contrainteGeometrique.getDistanceMin()) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        DIAGNOSTIC_SOURCE,
                        0,
                        "ERREUR : La distance Max doit être supérieure à Min.",
                        new Object[] { contrainteGeometrique }
                ));
            }
            return false;
        }
        return true;
    }

 // PAS de @Override ici
    public boolean validateContrainteRedondance(ContrainteRedondance contrainte, DiagnosticChain diagnostics, Map<Object, Object> context) {
        
        // CORRECTION : On appelle la validation par défaut générique d'EMF au lieu de "super"
        if (!validate_EveryDefaultConstraint(contrainte, diagnostics, context)) return false;

        // Règle : Redondance > 1
        if (contrainte.getNombreMinimum() <= 1) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(
                    Diagnostic.ERROR,
                    DIAGNOSTIC_SOURCE,
                    0,
                    "ERREUR : Une contrainte de redondance doit imposer au moins 2 exemplaires.",
                    new Object[] { contrainte }
                ));
            }
            return false;
        }
        return true;
    }

    @Override
    public ResourceLocator getResourceLocator() {
        return super.getResourceLocator();
    }

}