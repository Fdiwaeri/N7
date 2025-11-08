#ifndef COMPLEX_H
#define COMPLEX_H

// Type utilisateur complexe_t
struct complexe_t {
    double reelle;
    double imaginaire;
};
typedef struct complexe_t complexe_t;

// Fonctions reelle et imaginaire
/**
 * reelle
 * Cette fonction associe à un nombre complexe sa partie réelle
   * Paramètres :
   * complexe  [in] complexe_t 
   *
   * Retour : a défini par Re(complexe) = a
   *
   * Pré-conditions : 
   *   aucun 
   * Post-conditions :
   *   Re(complexe) = a
   * Cas d'erreur : aucun */

double reelle(complexe_t complexe);

/**
 * imaginaire
 * Cette fonction associe à un nombre complexe sa partie imaginaire
   * Paramètres :
   *  complexe  [in] complexe_t 
   *
   * Retour : a défini par Im(complexe) = a
   *
   * Pré-conditions : 
   *   aucun 
   * Post-conditions :
   *   Im(complexe) = a
   * Cas d'erreur : aucun */

double imaginaire(complexe_t complexe);

// Procédures set_reelle, set_imaginaire et init
/**
 * set_reelle
 *
 * Cette fonction modifie la partie réelle du nombre complexe donné avec le nombre réel donné
   * Paramètres :
   *  complexe  [in out] complexe_t* 
   *  reel  [in] double
   *
   * Pré-conditions : 
   *   aucun 
   * Post-conditions :
   *   reelle(*complexe) = reel
   * Cas d'erreur : aucun */
void set_reelle(complexe_t* complexe , double reel);
/**
 * set_imaginaire
 *
 * Cette fonction modifie la partie imaginaire du nombre complexe donné avec le nombre réel donné
   * Paramètres :
   *  complexe  [in out] complexe_t* 
   *  imaginaire  [in] double
   *
   * Pré-conditions : 
   *   aucun 
   * Post-conditions :
   *   imaginaire(*complexe) = imaginaire
   * Cas d'erreur : aucun */
void set_imaginaire(complexe_t* complexe , double imaginaire);

/**
 * init
 *
 * Cette fonction modifie la partie réelle et la partie imaginaire du nombre complexe donné avec les deux réels donnés
   * Paramètres :
   *  complexe  [in out] complexe_t* 
   *  reel  [in] double
   *  imaginaire  [in] double
   *
   * Pré-conditions : 
   *   aucun 
   * Post-conditions :
   *   reelle(*complexe) = reel
   *   imaginaire(*complexe) = imaginaire
   * Cas d'erreur : aucun */
void init(complexe_t* complexe , double reel, double imaginaire);

// Procédure copie
/**
 * copie
 * Copie les composantes du complexe donné en second argument dans celles du premier
 * argument
 *
 * Paramètres :
 *   resultat       [out] Complexe dans lequel copier les composantes
 *   autre          [in]  Complexe à copier
 *
 * Pré-conditions : resultat non null
 * Post-conditions : resultat et autre ont les mêmes composantes
 */
void copie(complexe_t* resultat, complexe_t autre);

// Algèbre des nombres complexes
/**
 * conjugue
 * Calcule le conjugué du nombre complexe op et le stocke dans resultat.
 *
 * Paramètres :
 *   resultat       [out] Résultat de l'opération
 *   op             [in]  Complexe dont on veut le conjugué
 *
 * Pré-conditions : resultat non-null
 * Post-conditions : reelle(*resultat) = reelle(op), complexe(*resultat) = - complexe(op)
 */
void conjugue(complexe_t* resultat, complexe_t op);

/**
 * ajouter
 * Réalise l'addition des deux nombres complexes gauche et droite et stocke le résultat dans resultat.
 *
 * Paramètres :
 *   resultat       [out] Résultat de l'opération
 *   gauche         [in]  Opérande gauche
 *   droite         [in]  Opérande droite
 *
 * Pré-conditions : resultat non-null
 * Post-conditions : *resultat = gauche + droite
 */
void ajouter(complexe_t* resultat, complexe_t gauche, complexe_t droite);

/**
 * soustraire
 * Réalise la soustraction des deux nombres complexes gauche et droite et stocke le résultat dans resultat.
 *
 * Paramètres :
 *   resultat       [out] Résultat de l'opération
 *   gauche         [in]  Opérande gauche
 *   droite         [in]  Opérande droite
 *
 * Pré-conditions : resultat non-null
 * Post-conditions : *resultat = gauche - droite
 */
void soustraire(complexe_t* resultat, complexe_t gauche, complexe_t droite);

/**
 * multiplier
 * Réalise le produit des deux nombres complexes gauche et droite et stocke le résultat dans resultat.
 *
 * Paramètres :
 *   resultat       [out] Résultat de l'opération
 *   gauche         [in]  Opérande gauche
 *   droite         [in]  Opérande droite
 *
 * Pré-conditions : resultat non-null
 * Post-conditions : *resultat = gauche * droite
 */
void multiplier(complexe_t* resultat, complexe_t gauche, complexe_t droite);

/**
 * echelle
 * Calcule la mise à l'échelle d'un nombre complexe avec le nombre réel donné (multiplication de op par le facteur réel facteur).
 *
 * Paramètres :
 *   resultat       [out] Résultat de l'opération
 *   op             [in]  Complexe à mettre à l'échelle
 *   facteur        [in]  Nombre réel à multiplier
 *
 * Pré-conditions : resultat non-null
 * Post-conditions : *resultat = op * facteur
 */
void echelle(complexe_t* resultat, complexe_t op, double facteur);

/**
 * puissance
 * Calcule la puissance entière du complexe donné et stocke le résultat dans resultat.
 *
 * Paramètres :
 *   resultat       [out] Résultat de l'opération
 *   op             [in]  Complexe dont on veut la puissance
 *   exposant       [in]  Exposant de la puissance
 *
 * Pré-conditions : resultat non-null, exposant >= 0
 * Post-conditions : *resultat = op * op * ... * op
 *                                 { n fois }
 */
void puissance(complexe_t* resultat, complexe_t op, int exposant);

// Module et argument
/**
 * module_carre
 *
 * Calcule le carré du module du complexe donné en paramètre.
 *
 * Paramètres :
 *   complexe   [in] complexe_t
 *
 * Retour : m défini par m = reelle(complexe)^2 + imaginaire(complexe)^2.
 *
 * Pré-conditions : aucun
 * Post-conditions : m = reelle(complexe)^2 + imaginaire(complexe)^2
 */
double module_carre(complexe_t complexe);
/**
 * module
 * Calcule le module du complexe donné en paramètre.
 *
 * Paramètres :
 *   complexe   [in] complexe_t
 *
 * Retour : m défini par m = sqrt(reelle(complexe)^2 + imaginaire(complexe)^2).
 *
 * Pré-conditions : aucun
 * Post-conditions : m = sqrt(reelle(complexe)^2 + imaginaire(complexe)^2)
 */
double module(complexe_t complexe);
/**
 * argument
 * Calcule l’argument du complexe donné en paramètre.
 *
 * Paramètres :
 *   complexe   [in] complexe_t
 *
 * Retour : theta défini par cos(theta) = reelle(complexe)/module(complexe) et sin(theta) = imaginaire(complexe)/module(complexe).
 *
 * Pré-conditions : aucun
 * Post-conditions :cos(theta) = reelle(complexe)/module(complexe) et sin(theta) = imaginaire(complexe)/module(complexe)
 */
double argument(complexe_t complexe);

#endif // COMPLEXE_H



