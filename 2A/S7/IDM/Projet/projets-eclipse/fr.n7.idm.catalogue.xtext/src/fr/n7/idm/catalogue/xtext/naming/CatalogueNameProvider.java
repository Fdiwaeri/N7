package fr.n7.idm.catalogue.xtext.naming; 

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.google.common.base.Function;

public class CatalogueNameProvider extends DefaultDeclarativeQualifiedNameProvider {

    /**
     * On dit à Xtext : "Pour trouver le nom d'un objet, cherche l'attribut 'nom' !"
     */
    @Override
    protected Function<EObject, String> getResolver() {
        // Le deuxième paramètre "nom" est le nom exact de votre attribut dans l'Ecore
        return SimpleAttributeResolver.newResolver(String.class, "nom");
    }
}