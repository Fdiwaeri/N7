package agentsmobiles.client;

import agentsmobiles.commun.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HotelAgent extends AgentImpl {
    // État de l'agent
    private int etape = 0;
    private ArrayList<String> listeHotels = new ArrayList<>();
    private HashMap<String, String> annuaire = new HashMap<>();
    private long startTime; // stocke l'heure de départ

    private Node serveurHotelNode;
    private Node serveurTelNode;

    // Méthode pour configurer l'itinéraire avant le départ
    public void setItinerary(Node n1, Node n2) {
        this.serveurHotelNode = n1;
        this.serveurTelNode = n2;
    }

    public void main() throws MoveException {
        // Étape 0 : Départ
        if (etape == 0) {
            System.out.println("[HotelAgent] Je démarre chez le client.");
            this.startTime = System.currentTimeMillis(); // lance le chrono
            etape = 1;
            move(serveurHotelNode); // aller vers serveur A (Hotels)
        }
        
        // Étape 1 : Arrivée sur serveur A (Hotels)
        else if (etape == 1) {
            System.out.println("[HotelAgent] Arrivé au Serveur Hôtels.");
            // Récupération du service local
            ArrayList<String> data = (ArrayList<String>) getNameServer().get("Hôtels");
            if (data != null) {
                this.listeHotels.addAll(data);
                System.out.println("[HotelAgent] J'ai récupéré la liste : " + listeHotels);
            }
            
            etape = 2;
            move(serveurTelNode); // aller vers serveur B (Téléphones)
        }
        
        // Étape 2 : Arrivée sur serveur B (Téléphones)
        else if (etape == 2) {
            System.out.println("[HotelAgent] Arrivé au Serveur Téléphones.");
            Map<String, String> phonesDb = (Map<String, String>) getNameServer().get("Téléphones");
            
            // Croisement des données
            for (String hotel : listeHotels) {
                if (phonesDb.containsKey(hotel)) {
                    annuaire.put(hotel, phonesDb.get(hotel));
                }
            }
            System.out.println("[HotelAgent] J'ai trouvé les numéros.");
            
            etape = 3;
            back(); // retour à la maison (origin est stocké dans AgentImpl)
        }
        
        // Étape 3 : Retour chez le client
        else if (etape == 3) {
            long endTime = System.currentTimeMillis(); // arret du chrono
            long duree = endTime - this.startTime;

            System.out.println("--- RÉSULTAT FINAL ---");
            System.out.println("Voici les hôtels et leurs numéros :");
            System.out.println(annuaire);
            System.out.println("TEMPS D'EXÉCUTION AGENT : " + duree + " ms");
        }
    }
}
