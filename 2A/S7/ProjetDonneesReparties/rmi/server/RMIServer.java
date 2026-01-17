package rmi.server;

import rmi.commun.*;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RMIServer {

    //Implémentation service Hotels
    static class HotelServiceImpl extends UnicastRemoteObject implements IHotelService {
        protected HotelServiceImpl() throws RemoteException { super(); }
        
        @Override
        public List<String> getHotels() throws RemoteException {
            System.out.println("[RMI Server] Demande de liste d'hôtels reçue.");
            // Cas simple 4 hotels
            return new ArrayList<>(Arrays.asList("Hotel A", "Hotel B", "Hotel C", "Hotel D"));
            // Cas A à Z
            /*
            List<String> list = new ArrayList<>();
            for (char c = 'A'; c <= 'Z'; c++) {
                list.add("Hotel " + c);
            }
            return list;
            **/
        }
    }

    // Implémentation service Téléphones
    static class PhoneServiceImpl extends UnicastRemoteObject implements IPhoneService {
        private Map<String, String> phones = new HashMap<>();

        protected PhoneServiceImpl() throws RemoteException { 
            super(); 
            // Cas somple 4 hotels
            /*
            phones.put("Hotel A", "0102030405");
            phones.put("Hotel B", "0607080910");
            phones.put("Hotel C", "0505050505");
            phones.put("Hotel D", "0404040404");
            **/
            // Cas A à Z
            for (char c = 'A'; c <= 'Z'; c++) {
                phones.put("Hotel " + c, "01020300" + (int)c);
            }
        }
        
        @Override
        public String getPhone(String hotelName) throws RemoteException {
            // chaque appel est un message réseau
            System.out.println("[RMI Server] Demande de numéro pour : " + hotelName);
            return phones.get(hotelName);
        }
    }

    // Implémentation Service Fichier / Compression
    static class FileServiceImpl extends UnicastRemoteObject implements IFileService {
        private String grosFichier;

        protected FileServiceImpl() throws RemoteException { 
            super();
            // Génération d'un gros contenu
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<1; i++) {
                sb.append("DONNEES_LOURDES_A_COMPRESSER_POUR_RMI_");
            }
            this.grosFichier = sb.toString();
        }
        
        @Override
        public String getFichierConfidenciel() throws RemoteException {
            System.out.println("[RMI Server] Transfert du gros fichier (" + grosFichier.length() + " octets) vers le client...");
            return grosFichier;
        }
    }

    public static void main(String[] args) {
        try {
            if (args.length > 0) {
                System.setProperty("java.rmi.server.hostname", args[0]);
            } else {
                // Sinon on tente de deviner (risqué à l'école)
                System.setProperty("java.rmi.server.hostname", java.net.InetAddress.getLocalHost().getHostAddress());
            }
            // Création du registre RMI sur le port 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            
            // Enregistrement des services
            registry.rebind("Hotels", new HotelServiceImpl());
            registry.rebind("Phones", new PhoneServiceImpl());
            registry.rebind("Fichier", new FileServiceImpl());
            
            System.out.println("SERVEUR RMI PRÊT (Port 1099)");
            System.out.println("Services enregistrés : Hotels, Phones, Fichier");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
