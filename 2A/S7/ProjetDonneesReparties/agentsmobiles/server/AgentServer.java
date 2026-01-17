package agentsmobiles.server;

import agentsmobiles.commun.*;

import java.io.*;
import java.net.*;
import java.util.Hashtable;

public class AgentServer implements Runnable {
    private int port;
    private Hashtable<String, Object> services = new Hashtable<>();

    public AgentServer(int port) {
        this.port = port; 
    }

    public void registerService(String name, Object service) {
        services.put(name, service);
    }

    public void run() {
        try (ServerSocket ss = new ServerSocket(port)) {
            System.out.println("Serveur prêt sur le port " + port);
            while (true) {
                Socket s = ss.accept();
                new Thread(() -> handleAgent(s)).start(); 
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

    private void handleAgent(Socket s) {
        try {
            // On utilise un tableau à 1 case pour que la variable soit final
            // mais modifiable à l'intérieur de la classe anonyme
            final AgentClassLoader[] loaderHolder = new AgentClassLoader[1];

            // le flux d'entrée
            ObjectInputStream in = new ObjectInputStream(s.getInputStream()) {
                @Override
                protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
                    // Si on a chargé le loader, on l'utilise
                    if (loaderHolder[0] != null) {
                        try {
                            return loaderHolder[0].loadClass(desc.getName());
                        } catch (ClassNotFoundException e) {
                            return super.resolveClass(desc);
                        }
                    }
                    // sinon comportement standard (pour lire le String et les byte[])
                    return super.resolveClass(desc);
                }
            };

            // On lit les métadonnées avec le flux (resolveClass standard)
            String className = (String) in.readObject();
            byte[] classBytes = (byte[]) in.readObject();

            // on crée le loader et on le stocke dans le holder
            //les prochains appels à readObject utiliseront ce loader via resolveClass
            loaderHolder[0] = new AgentClassLoader(className, classBytes);

            // On lit l'agent (resolveClass utilisera loaderHolder[0])
            Agent agent = (Agent) in.readObject();

            // Initialisation et lancement
            agent.setNameServer(this.services);
            if (agent instanceof Runnable) {
                new Thread((Runnable) agent).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java agentsmobiles.AgentServer <port>");
            return;
        }
        int port = Integer.parseInt(args[0]);
        AgentServer server = new AgentServer(port);
        
        // Enregistrement des services (Simulation pour la démo)
        if (port == 2000) { // Serveur A (Hôtels)
            // Cas simple avec 4 hotels
            server.registerService("Hôtels", new java.util.ArrayList<>(java.util.Arrays.asList("Hotel A", "Hotel B", "Hotel C", "Hotel D")));
            // Cas de A à Z
            /*
            java.util.ArrayList<String> list = new java.util.ArrayList<>();
            for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
                list.add("Hotel " + alphabet);
            }
            server.registerService("Hôtels", list);
            **/
        }
        if (port == 3000) { // Serveur B (Téléphones)
            java.util.Map<String, String> phones = new java.util.HashMap<>();
            // Cas simple de 4 hotels
            /*
            phones.put("Hotel A", "0102030405");
            phones.put("Hotel B", "0607080910");
            phones.put("Hotel C", "0505050505");
            phones.put("Hotel D", "0404040404");
            **/
            // Cas de 1 à Z
            for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
                // On génère un faux numéro (ex: 0102030065 pour A)
                phones.put("Hotel " + alphabet, "01020300" + (int)alphabet);
            }
            server.registerService("Téléphones", phones);
        }
        if (port == 4000) { // Serveur Fichiers
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<1; i++) {
                sb.append("DONNEES_LOURDES_A_COMPRESSER_POUR_RMI_");
            }
            server.registerService("FichierConfidenciel", sb.toString());
            System.out.println("Service Fichier enregistré (" + sb.length() + " octets)");
        }
        
        new Thread(server).start();
    }

}
