/** Un programme de test simple pour vérifier que la classe
 * EnsembleOrdonneChaine<Integer> marche bien, avec vérification
 * à l'affichage.
 * Non demandé dans le sujet!
 * 
 * @author F.E
 */

public class EnsembleOrdonneChaineTest {
    public static void main(String[] args) {
        EnsembleOrdonneChaine<Integer> ens = new EnsembleOrdonneChaine<Integer>();
        System.out.println("> Initialisation de l'ensemble :");
        ens.ajouter(6);
        ens.ajouter(5);
        ens.ajouter(3);
        ens.ajouter(2);
        ens.afficher();
        System.out.println();
        System.out.println("> Test de min() :");
        System.out.println("Le min est: "+ ens.min());
        System.out.println();
        System.out.println("> Ajout de 4 à l'ensemble :");
        ens.ajouter(4);
        ens.afficher();
        System.out.println("> Test de justePlusGrandQue() :");
        System.out.println("L'élément juste plus grand que 1 : " + ens.justePlusGrandQue(1));
        System.out.println("L'élément juste plus grand que 3 : " + ens.justePlusGrandQue(3));
        System.out.println("L'élément juste plus grand que 7 : " + ens.justePlusGrandQue(7));
    }
}