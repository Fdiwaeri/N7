package rmi.client;

import rmi.commun.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClientCompress {
    public static void main(String[] args) {
        try {
            // Usage : java rmi.client.RMIClientCompress <IP_SERVEUR_RMI>
            String host = (args.length < 1) ? "localhost" : args[0];
            
            long debut = System.currentTimeMillis();
            
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            IFileService fileService = (IFileService) registry.lookup("Fichier");
            
            System.out.println("[Client RMI] Téléchargement du fichier complet...");
            
            // Le gros fichier
            String data = fileService.getFichierConfidenciel();
            
            System.out.println("[Client RMI] Fichier reçu (" + data.length() + " octets). Compression locale...");
            
            // Compression locale 
            int tailleCible = (int) (data.length() * 0.20);
            String compressed = data.substring(0, tailleCible);
            
            long fin = System.currentTimeMillis();
            
            System.out.println("--- RÉSULTAT FINAL RMI ---");
            System.out.println("Taille finale : " + compressed.length());
            System.out.println("Temps d'exécution : " + (fin - debut) + " ms");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
