#include "complexe.h"
#include <math.h>           // Pour certaines fonctions trigo notamment
#ifndef M_PI
#define M_PI 3.14159265358979323846 
#endif

// Implantations de reelle et imaginaire
double reelle(complexe_t complexe) {
    return complexe.reelle;
}


double imaginaire(complexe_t complexe) {
    return complexe.imaginaire;
}

// Implantations de set_reelle et set_imaginaire
void set_reelle(complexe_t* complexe , double reel) {
    complexe->reelle = reel;
}


void set_imaginaire(complexe_t* complexe , double imaginaire) {
    complexe->imaginaire = imaginaire;
}


void init(complexe_t* complexe , double reel, double imaginaire) {
    set_reelle(complexe , reel);
    set_imaginaire(complexe , imaginaire);
}

// Implantation de copie
void copie(complexe_t* resultat, complexe_t autre) {
    init(resultat, autre.reelle, autre.imaginaire);
}
    
// Implantations des fonctions algébriques sur les complexes
void conjugue(complexe_t* resultat, complexe_t op) {
     init(resultat, op.reelle, -op.imaginaire);
}


void ajouter(complexe_t* resultat, complexe_t gauche, complexe_t droite) {
    init(resultat, gauche.reelle + droite.reelle, gauche.imaginaire + droite.imaginaire);
}


void soustraire(complexe_t* resultat, complexe_t gauche, complexe_t droite) {
    resultat->reelle = gauche.reelle - droite.reelle;
    resultat->imaginaire = gauche.imaginaire - droite.imaginaire;
}


void multiplier(complexe_t* resultat, complexe_t gauche, complexe_t droite) {
    resultat->reelle = (gauche.reelle*droite.reelle)-(gauche.imaginaire*droite.imaginaire);
    resultat->imaginaire = (gauche.reelle*droite.imaginaire)+(gauche.imaginaire*droite.reelle);
}


void echelle(complexe_t* resultat, complexe_t op, double facteur) {
    init(resultat , facteur*op.reelle, facteur*op.imaginaire);
}


void puissance(complexe_t* resultat, complexe_t op, int exposant) {
    resultat->reelle = op.reelle;
    resultat->imaginaire = op.imaginaire;
    for (int i = 2; i <= exposant; i++) {
        multiplier(resultat, *resultat, op);
    }
}


// Implantations du module et de l'argument
double module_carre(complexe_t complexe) {
    return ((complexe.reelle * complexe.reelle) + (complexe.imaginaire * complexe.imaginaire));
}


double module(complexe_t complexe) {
    return sqrt(module_carre(complexe));
}


double argument(complexe_t complexe) {
    double x = complexe.reelle;
    double y = complexe.imaginaire;
    if (x > 0) {
        return atan(y / x);
    } else if (x < 0) {
        if (y < 0){
            return (atan(y / x) - M_PI);
        } else if (y > 0) {
            return (atan(y / x) + M_PI);
        } else {
            return M_PI ;
        }
    } else {
        if (y < 0){
            return 3.0 * M_PI / 2.0;
        } else if (y > 0) {
            return M_PI / 2.0 ;
        } else {
            return 0.0 ;
        }
    }
}
 

