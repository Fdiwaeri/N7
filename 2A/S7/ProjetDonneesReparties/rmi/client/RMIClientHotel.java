package rmi.client;

import rmi.commun.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RMIClientHotel {
    public static void main(String[] args) {
        try {
            long debut = System.currentTimeMillis();
            
            // Connexion au registre
            String serverIp = (args.length > 0) ? args[0] : "localhost";
            Registry registry = LocateRegistry.getRegistry(serverIp, 1099);
            
            // Récupération des stubs (proxy)
            IHotelService hotelService = (IHotelService) registry.lookup("Hotels");
            IPhoneService phoneService = (IPhoneService) registry.lookup("Phones");
            
            // Appel distant 1 : récupérer la liste
            System.out.println("[Client RMI] Récupération de la liste des hôtels...");
            List<String> hotels = hotelService.getHotels();
            
            // Appels distants N : récupérer les numéros un par un
            Map<String, String> annuaire = new HashMap<>();
            System.out.println("[Client RMI] Récupération des numéros (Boucle d'appels distants)...");
            
            for (String h : hotels) {  // latence x N
                String num = phoneService.getPhone(h); 
                if (num != null) annuaire.put(h, num);
            }
            
            long fin = System.currentTimeMillis();
            
            System.out.println("--- RÉSULTAT FINAL RMI ---");
            System.out.println(annuaire);
            System.out.println("Temps d'exécution : " + (fin - debut) + " ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
