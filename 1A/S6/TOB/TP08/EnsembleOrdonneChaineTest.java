public class EnsembleOrdonneChaineTest {
    public static void main(String[] args) {
        EnsembleOrdonneChaine ens = new EnsembleOrdonneChaine();
        ens.ajouter(6);
        ens.ajouter(5);
        ens.ajouter(3);
        ens.ajouter(2);
        ens.afficher();
        System.out.println();
        System.out.println("Le min est: "+ ens.min());
        System.out.println();
        ens.ajouter(4);
        ens.afficher();
    }
}