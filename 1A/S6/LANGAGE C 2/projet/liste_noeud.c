#define _GNU_SOURCE
#include "liste_noeud.h"
#include <stdlib.h>
#include <math.h>

/**
 * Cellule d'une liste.
 */
typedef struct cellule {
    /** Le noeud. */
    noeud_id_t noeud;
    /** Le noeud précédent. */
    noeud_id_t precedent;
    /** La distance. */
    float distance;
    /** Pointeur sur la cellule suivante */
    struct cellule* suivante;
} _cellule;

/**
 * Liste de noeuds.
 */
struct liste_noeud_t {
    /* Pointeur sur la première cellule */
    _cellule* premiere;
    /* Pointeur sur la dernière cellule */
    _cellule* derniere;
};


liste_noeud_t* creer_liste() {
    liste_noeud_t* liste = (liste_noeud_t*)malloc(sizeof(liste_noeud_t));
    if (liste != NULL) {
        liste->premiere = NULL;
        liste->derniere = NULL;
    }
    return liste;
}

void detruire_liste(liste_noeud_t** liste_ptr) {
    if (liste_ptr != NULL && *liste_ptr != NULL) {
        _cellule* temp = (*liste_ptr)->premiere;
        while (temp != NULL) {
            _cellule* suivante = temp->suivante;
            free(temp);
            temp = suivante;
        }
        (*liste_ptr)->premiere=NULL;
        (*liste_ptr)->derniere=NULL;
        free(*liste_ptr);
        *liste_ptr = NULL;
    }
}

bool est_vide_liste(const liste_noeud_t* liste) {
    if (liste != NULL) {
        return (liste->premiere == NULL && liste->derniere == NULL);
    }
    return true;
}

bool contient_noeud_liste(const liste_noeud_t* liste, noeud_id_t noeud) {
    if (est_vide_liste(liste)) {
        return false;
    }
    _cellule* temp = liste->premiere;
    while (temp != NULL) {
        if (temp->noeud == noeud) {
            return true;
        }
        temp = temp->suivante;
    }
    return false;
}

bool contient_arrete_liste(const liste_noeud_t* liste, noeud_id_t source, noeud_id_t destination) {
    if (est_vide_liste(liste)) {
        return false;
    }
    if (contient_noeud_liste(liste, destination) && (precedent_noeud_liste(liste, destination) == source)) {
        return true;
    }
    return false;
}

float distance_noeud_liste(const liste_noeud_t* liste, noeud_id_t noeud) {
    if (est_vide_liste(liste)) {
        return INFINITY;
    }
    _cellule* temp = liste->premiere;
    while (temp != NULL) {
        if (temp->noeud == noeud) {
            return temp->distance;
        }
        temp = temp->suivante;
    }
    return INFINITY;
}

noeud_id_t precedent_noeud_liste(const liste_noeud_t* liste, noeud_id_t noeud) {
    if (est_vide_liste(liste)) {
        return NO_ID;
    }
    _cellule* temp = liste->premiere;
    while (temp != NULL) {
        if (temp->noeud == noeud) {
            return temp->precedent;
        }
        temp = temp->suivante;
    }
    return NO_ID;
}

noeud_id_t min_noeud_liste(const liste_noeud_t* liste) {
    if (est_vide_liste(liste)) {
        return NO_ID;
    }
    noeud_id_t min = liste->premiere->noeud;
    float dist_min = liste->premiere->distance;
    _cellule* temp = liste->premiere->suivante;
    while (temp != NULL) {
        if (temp->distance < dist_min) {
            dist_min = temp->distance;
            min = temp->noeud;
        }
        temp = temp->suivante;
    }
    return min;
}

void inserer_noeud_liste(liste_noeud_t* liste, noeud_id_t noeud, noeud_id_t precedent, float distance) {
    // si la liste contient déjà le noeud, ne rien faire
    if (contient_noeud_liste(liste, noeud) == true) {
        return;
    }
    // sinon, on crée la cellule du noeud à insérer
    _cellule* nouvelle = (_cellule*)malloc(sizeof(_cellule));
    nouvelle->noeud = noeud;
    nouvelle->precedent = precedent;
    nouvelle->distance = distance;
    nouvelle->suivante = NULL;
    // si la liste est vide, insérer au début
    if (est_vide_liste(liste)) {
        liste->premiere = nouvelle;
        liste->derniere = nouvelle;
        return;
    }
    // sinon insérer à la fin en mettant à jour derniere
    liste->derniere->suivante = nouvelle;
    liste->derniere = nouvelle;
}

void changer_noeud_liste(liste_noeud_t* liste, noeud_id_t noeud, noeud_id_t precedent, float distance) {
    if (!contient_noeud_liste(liste,noeud)) {
        inserer_noeud_liste(liste, noeud, precedent, distance);
        return;
    }
    _cellule* temp = liste->premiere;
    while (temp != NULL) {
        if (temp->noeud == noeud) {
            temp->precedent = precedent;
            temp->distance = distance;
            return;
        }
        temp = temp->suivante;
    }
}

void supprimer_noeud_liste(liste_noeud_t* liste, noeud_id_t noeud) {
    if (!contient_noeud_liste(liste,noeud)) {
        return;
    }
    _cellule* temp = liste->premiere;
    if (temp->noeud == noeud) {
         liste->premiere = temp->suivante;
         if (liste->premiere == NULL) {
            liste->derniere = NULL;
         }
         free(temp);
         return;
     }
    while (temp->suivante != NULL && temp->suivante->noeud != noeud) {
        temp = temp->suivante;
    }
    if (temp->suivante != NULL) {
        _cellule* ptr = temp->suivante;
        temp->suivante = ptr->suivante;
        if (liste->derniere == ptr) {
            liste->derniere = temp;
        }
        free(ptr);
    }
}
