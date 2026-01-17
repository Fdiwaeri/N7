package fr.n7.layout.design;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import layout.Board;
import layout.ComposantPosition;
import layout.CoucheExterne;
import layout.Layout;
import layout.Piste;

// Imports Netlist
import netlist.Connexion;
import netlist.ConnexionPort;
import netlist.InstanceComposant;
// PLUS BESOIN DE "import netlist.Port;" !

public class Services {

    // Aide pour l'outil de création
    public EObject selectionnerInstanceNetlist(EObject context) {
        return null;
    }

    // Récupère le composant au début de la piste (Source)
    public ComposantPosition getComposantSource(Piste piste) {
        Connexion c = piste.getConnexion();
        
        // Sécurité
        if (c == null || c.getConnextionsPort().isEmpty()) return null;
        
        // 1. On récupère le premier lien (ConnexionPort)
        ConnexionPort cp = c.getConnextionsPort().get(0);
        
        // 2. On récupère DIRECTEMENT l'instance (défini dans netlist.ecore)
        InstanceComposant instanceSource = cp.getInstance();
        
        // 3. On cherche le carré correspondant
        if (instanceSource != null) {
            return trouverPositionDansLayout(piste, instanceSource);
        }
        return null;
    }

    // Récupère le composant à la fin de la piste (Cible)
    public ComposantPosition getComposantCible(Piste piste) {
        Connexion c = piste.getConnexion();
        
        if (c == null || c.getConnextionsPort().size() < 2) return null;
        
        // 1. On récupère le dernier lien
        ConnexionPort cp = c.getConnextionsPort().get(c.getConnextionsPort().size() - 1);
        
        // 2. On récupère DIRECTEMENT l'instance
        InstanceComposant instanceCible = cp.getInstance();
        
        // 3. On cherche le carré correspondant
        if (instanceCible != null) {
            return trouverPositionDansLayout(piste, instanceCible);
        }
        return null;
    }

    // Méthode utilitaire inchangée
    private ComposantPosition trouverPositionDansLayout(Piste piste, InstanceComposant instanceCherchee) {
        EObject container = piste.eContainer();
        while (container != null && !(container instanceof Layout)) {
            container = container.eContainer();
        }
        
        if (container instanceof Layout) {
            Layout layoutRoot = (Layout) container;
            for (Board board : layoutRoot.getBoards()) {
                for (Object coucheObj : board.getCouches()) {
                     if (coucheObj instanceof CoucheExterne) {
                         CoucheExterne couche = (CoucheExterne) coucheObj;
                         for (ComposantPosition compPos : couche.getComposants()) {
                             if (compPos.getInstance() != null && compPos.getInstance().equals(instanceCherchee)) {
                                 return compPos;
                             }
                         }
                     }
                }
            }
        }
        return null;
    }
}