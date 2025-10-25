package petriNet.validation;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

// Importez le package de Petri Net pour accéder aux IDs
import petriNet.PetriNetPackage; 

/**
 * Programme principal pour la validation des modèles Petri Net.
 */
public class ValidatePetrinet {
	
	// Utilisation des méthodes afficherErreurs et afficherResultat de SimplePDL, 
	// en les adaptant au contexte de Petri Net.
	
	private static void afficherErreurs(String prefix, List<ValidationResult.ValidationError> errors) {
		System.out.print(prefix + ":");
		if (errors.isEmpty()) {
			System.out.println(" OK");
		} else {
			System.out.println(" " + errors.size() + " erreurs trouvées");
			for (ValidationResult.ValidationError error : errors) {
				System.out.println("=> " + error.toString());
			}
		}
	}
	
	/**
	 * Affiche les erreurs pour les divers éléments du méta-modèle Petri Net.
	 */
	private static void afficherResultat(ValidationResult resultat) {
		// Utilisez les IDs de classes du PetriNetPackage
		afficherErreurs("- PetriNet", resultat.getRecordedErrorsFor(PetriNetPackage.PETRI_NET));
		afficherErreurs("- Place", resultat.getRecordedErrorsFor(PetriNetPackage.PLACE));
		afficherErreurs("- Transition", resultat.getRecordedErrorsFor(PetriNetPackage.TRANSITION));
		// Vérifiez les noms exacts des sous-classes d'Arc dans votre package.
		afficherErreurs("- Arc (General)", resultat.getRecordedErrorsFor(PetriNetPackage.ARC));
		afficherErreurs("- ArcPlaceTransition", resultat.getRecordedErrorsFor(PetriNetPackage.ARC_PLACE_TRANSITION));
		afficherErreurs("- ArcTransitionPlace", resultat.getRecordedErrorsFor(PetriNetPackage.ARC_TRANSITION_PLACE));
	}

	public static void main(String... args) {
		// Chargement du méta-modèle Petri Net
		@SuppressWarnings("unused")
		PetriNetPackage packageInstance = PetriNetPackage.eINSTANCE;
		
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		// Assurez-vous d'avoir enregistré l'extension du modèle Petri Net si elle n'est pas .xmi
		m.put("xmi", new XMIResourceFactoryImpl());
		
		ResourceSet resSet = new ResourceSetImpl();
		
		// Utilisation du nouveau validateur
		PetrinetValidator validator = new PetrinetValidator();

		for (String model : args) {
			URI modelURI = URI.createURI(model);
			Resource resource = resSet.getResource(modelURI, true);
			ValidationResult resultat = validator.validate(resource);
			
			System.out.println("Résultat de validation pour " + model + ":");
			afficherResultat(resultat);
		}
		
		System.out.println("Fini.");
	
	}

}