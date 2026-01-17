package agentsmobiles.client;

import agentsmobiles.commun.*;

public class CompressAgent extends AgentImpl {
    private int etape = 0;
    private String dataCompresses = null;
    private int tailleOriginale = 0;
    private long startTime;
    private Node serverNode; // la destination

    // Méthode pour configurer la destination
    public void setServerNode(Node n) {
        this.serverNode = n;
    }

    public void main() throws MoveException {
        if (etape == 0) {
            System.out.println("[CompressAgent] Je pars chercher et compresser le fichier.");
            this.startTime = System.currentTimeMillis(); // lance le chrono
            etape = 1;
            if (serverNode == null) {
                serverNode = new Node("localhost", 4000);
            }
            move(serverNode); // Aller vers le serveur fichier
        }
        else if (etape == 1) {
            System.out.println("[CompressAgent] Arrivé sur le serveur de fichiers.");
            String data = (String) getNameServer().get("FichierConfidenciel");
            
            if (data != null) {
                this.tailleOriginale = data.length();
                System.out.println("[CompressAgent] Fichier trouvé (" + tailleOriginale + " octets).");
                System.out.println("[CompressAgent] COMPRESSION en cours (Local)...");

                // Simulation de compression
                int tailleCible = (int) (this.tailleOriginale * 0.20); // 20% de la taille
                this.dataCompresses = data.substring(0, tailleCible);
                System.out.println("[CompressAgent] Compression terminée : " + this.tailleOriginale + " -> " + this.dataCompresses.length() + " octets.");
            }
            
            etape = 2;
            back(); // retour avec seulement les données compressées
        }
        else if (etape == 2) {
            long endTime = System.currentTimeMillis(); // arret du chrono
            long duree = endTime - this.startTime;
            System.out.println("--- RÉSULTAT FINAL ---");
            System.out.println("Taille originale sur le serveur : " + tailleOriginale);
            System.out.println("Taille reçue (après compression 20%) : " + dataCompresses.length());
            System.out.println("TEMPS D'EXÉCUTION AGENT : " + duree + " ms");
        }
    }
}
