#include "dijkstra.h"
#include <stdlib.h>

/**
 * construire_chemin_vers - Construit le chemin depuis le noeud de départ donné vers le
 * noeud donné. On passe un chemin en entrée-sortie de la fonction, qui est mis à jour
 * par celle-ci.
 *
 * Le noeud de départ est caractérisé par un prédécesseur qui vaut `NO_ID`.
 *
 * Ce sous-programme fonctionne récursivement :
 *  1. Si le noeud a pour précédent `NO_ID`, on a fini (c'est le noeud de départ, le chemin de
 *     départ à départ se compose du simple noeud départ)
 *  2. Sinon, on construit le chemin du départ au noeud précédent (appel récursif)
 *  3. Dans tous les cas, on ajoute le noeud au chemin, avec les caractéristiques associées dans visites
 *
 * @param chemin [in/out] chemin dans lequel enregistrer les étapes depuis le départ vers noeud
 * @param visites [in] liste des noeuds visités créée par l'algorithme de Dijkstra
 * @param noeud noeud vers lequel on veut construire le chemin depuis le départ
 */
void construire_chemin_vers(
    liste_noeud_t** chemin,
    const liste_noeud_t* visites,
    noeud_id_t noeud) {
    float distance = distance_noeud_liste(visites, noeud);
    // (C-1) Soit n_p = prec AVisiter (n)
    // noeud_prec (n_p) est le noeud précédent de noeud (n)
    noeud_id_t noeud_prec = precedent_noeud_liste(visites, noeud);
    // (C-2) Si n_p = ∗ (càd noeud_prec = NO_ID),
    //       on s’arrête ici car normalement n = n_d
    if (noeud_prec == NO_ID) {
        inserer_noeud_liste(*chemin, noeud, NO_ID, distance);
        return;
    }
    // (C-3) Sinon :
    // (C-3.1) Construire le chemin de n_d (source) à n_p (noeud_prec)
    construire_chemin_vers(chemin, visites, noeud_prec);
    // (C-3.2) Ajouter au chemin le noeud n_p
    inserer_noeud_liste(*chemin, noeud, noeud_prec, distance);
}
    

float dijkstra(
    const struct graphe_t* graphe, 
    noeud_id_t source, noeud_id_t destination, 
    liste_noeud_t** chemin) {
    liste_noeud_t* a_visiter = creer_liste();
    liste_noeud_t* visites = creer_liste();
    
    // La partie "D":
    inserer_noeud_liste(a_visiter, source, NO_ID, 0);
    while (!est_vide_liste(a_visiter)) {
        noeud_id_t noeud_courant =  min_noeud_liste(a_visiter);
        noeud_id_t prec_courant = precedent_noeud_liste(a_visiter, noeud_courant);
        float dist_courant = distance_noeud_liste(a_visiter, noeud_courant);
        inserer_noeud_liste(visites, noeud_courant, prec_courant, dist_courant);
        supprimer_noeud_liste(a_visiter, noeud_courant);
        if (noeud_courant == destination) {
            break; // il faut s'arreter si on atteint la destination
        }
        size_t nb_voisins = nombre_voisins(graphe, noeud_courant);
        noeud_id_t* voisins = (noeud_id_t*)malloc(nb_voisins * sizeof(noeud_id_t));
        if (voisins != NULL) {
            noeuds_voisins(graphe, noeud_courant, voisins);
            for (long unsigned int i = 0; i<nb_voisins; i++) {
                noeud_id_t voisin = voisins[i];
                if (!contient_noeud_liste(visites, voisin)) {
                    float dist_totale = dist_courant + noeud_distance(graphe, noeud_courant, voisin);
                    float dist_a_visiter = distance_noeud_liste(a_visiter, voisin);
                    if (dist_totale < dist_a_visiter) {
                        changer_noeud_liste(a_visiter, voisin, noeud_courant, dist_totale);
                    }
                }
            }
            free(voisins);
        }
    }
    
    // La partie "C":
    // Calculer le chemin si chemin ne vaut pas NULL
    if (chemin != NULL) {
        *chemin = creer_liste();

        // Vérifier si un chemin de la source vers la destination a été trouvé
        if (contient_noeud_liste(visites, destination)) {
            // Construire le chemin
            construire_chemin_vers(chemin, visites, destination);
        }
    }
    
    // Récupérer la distance minimale depuis la source à la destination
    float distance_minimale = distance_noeud_liste(visites, destination);
    
    // Libérer la mémoire
    detruire_liste(&a_visiter);
    detruire_liste(&visites);
    
    return distance_minimale;
}
