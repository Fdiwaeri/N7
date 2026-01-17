/**
 */
package layout.util;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import layout.*;

// --- IMPORTS DES AUTRES PROJETS 
import fr.n7.idm.catalogue.Empreinte;
import netlist.InstanceComposant; 

/**
 * Validator adapté au nouveau métamodèle Layout (Board, Point, Double).
 * @generated
 */
public class LayoutValidator extends EObjectValidator {
    public static final LayoutValidator INSTANCE = new LayoutValidator();
    public static final String DIAGNOSTIC_SOURCE = "fr.n7.idm.layout";
    public static final int DIAGNOSTIC_CODE_COUNT = 0;

    public LayoutValidator() {
        super();
    }

    @Override
    protected EPackage getEPackage() {
        return LayoutPackage.eINSTANCE;
    }

    @Override
    protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
        switch (classifierID) {
            case LayoutPackage.LAYOUT:
                return validateLayout((Layout)value, diagnostics, context);
            case LayoutPackage.BOARD:
                return validateBoard((Board)value, diagnostics, context);
            case LayoutPackage.COUCHE:
                return validateCouche((Couche)value, diagnostics, context);
            case LayoutPackage.COUCHE_EXTERNE:
                return validateCoucheExterne((CoucheExterne)value, diagnostics, context);
            case LayoutPackage.COUCHE_INTERNE:
                return validateCoucheInterne((CoucheInterne)value, diagnostics, context);
            case LayoutPackage.COMPOSANT_POSITION:
                return validateComposantPosition((ComposantPosition)value, diagnostics, context);
            case LayoutPackage.PISTE:
                return validatePiste((Piste)value, diagnostics, context);
            case LayoutPackage.POINT:
                return validatePoint((Point)value, diagnostics, context);
            default:
                return true;
        }
    }

    public boolean validateLayout(Layout layout, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(layout, diagnostics, context);
    }

    /**
     * Validation du Board : Vérifier que les dimensions sont positives.
     * @generated NOT
     */
    public boolean validateBoard(Board board, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (!validate_EveryDefaultConstraint(board, diagnostics, context)) return false;
        
        if (board.getLargeur() <= 0 || board.getHauteur() <= 0) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(
                    Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0,
                    "ERREUR : Les dimensions du Board doivent être positives.",
                    new Object[] { board }));
            }
            return false;
        }
        return true;
    }

    public boolean validateCouche(Couche couche, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(couche, diagnostics, context);
    }

    public boolean validateCoucheInterne(CoucheInterne coucheInterne, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(coucheInterne, diagnostics, context);
    }

    public boolean validateCoucheExterne(CoucheExterne coucheExterne, DiagnosticChain diagnostics, Map<Object, Object> context) {
        // Appels standards
        if (!validate_NoCircularContainment(coucheExterne, diagnostics, context)) return false;
        boolean result = validate_EveryMultiplicityConforms(coucheExterne, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryDataValueConforms(coucheExterne, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(coucheExterne, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(coucheExterne, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryProxyResolves(coucheExterne, diagnostics, context);
        if (result || diagnostics != null) result &= validate_UniqueID(coucheExterne, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryKeyUnique(coucheExterne, diagnostics, context);
        if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(coucheExterne, diagnostics, context);
        
        // --- APPEL DE LA RÈGLE DE CHEVAUCHEMENT ---
        if (result || diagnostics != null) result &= validateCoucheExterne_nonChevauchement(coucheExterne, diagnostics, context);
        
        return result;
    }

    /**
     * Règle : Détection de collision (AABB) adaptée aux Doubles et à la nouvelle Netlist.
     * @generated NOT
     */
    public boolean validateCoucheExterne_nonChevauchement(CoucheExterne couche, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean estValide = true;

        for (ComposantPosition pos1 : couche.getComposants()) {
            for (ComposantPosition pos2 : couche.getComposants()) {
                
                if (pos1 == pos2) continue;

                // --- 1. Infos Composant 1 ---
                if (pos1.getInstance() == null) continue; // Notez le changement : getInstance()
                if (pos1.getInstance().getDefinition() == null) continue;
                
                Empreinte emp1 = pos1.getInstance().getDefinition().getEmpreinte();
                if (emp1 == null) continue; 

                // Note : On ignore la rotation pour simplifier (AABB simple)
                double x1_min = pos1.getX();
                double x1_max = x1_min + emp1.getLargeur();
                double y1_min = pos1.getY();
                double y1_max = y1_min + emp1.getHauteur();

                // --- 2. Infos Composant 2 ---
                if (pos2.getInstance() == null) continue;
                if (pos2.getInstance().getDefinition() == null) continue;
                
                Empreinte emp2 = pos2.getInstance().getDefinition().getEmpreinte();
                if (emp2 == null) continue;

                double x2_min = pos2.getX();
                double x2_max = x2_min + emp2.getLargeur();
                double y2_min = pos2.getY();
                double y2_max = y2_min + emp2.getHauteur();

                // --- 3. Test Collision ---
                boolean collisionX = (x1_min < x2_max) && (x1_max > x2_min);
                boolean collisionY = (y1_min < y2_max) && (y1_max > y2_min);

                if (collisionX && collisionY) {
                    if (diagnostics != null) {
                        String nom1 = pos1.getInstance().getNom();
                        String nom2 = pos2.getInstance().getNom();
                        
                        diagnostics.add(new BasicDiagnostic(
                            Diagnostic.ERROR,
                            DIAGNOSTIC_SOURCE,
                            0,
                            "ERREUR GRAVE : Chevauchement entre '" + nom1 + "' et '" + nom2 + "'.",
                            new Object[] { pos1, pos2 }
                        ));
                    }
                    estValide = false;
                }
            }
        }
        return estValide;
    }

    public boolean validateComposantPosition(ComposantPosition composantPosition, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(composantPosition, diagnostics, context);
    }

    /**
     * Validation Piste : Largeur positive.
     * @generated NOT
     */
    public boolean validatePiste(Piste piste, DiagnosticChain diagnostics, Map<Object, Object> context) {
         if (!validate_EveryDefaultConstraint(piste, diagnostics, context)) return false;

         if (piste.getLargeur() <= 0) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(
                    Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0,
                    "ERREUR : Une piste doit avoir une largeur positive.",
                    new Object[] { piste }));
            }
            return false;
         }
         return true;
    }

    public boolean validatePoint(Point point, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(point, diagnostics, context);
    }

    @Override
    public ResourceLocator getResourceLocator() {
        return super.getResourceLocator();
    }
}