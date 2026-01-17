package agentsmobiles.client;

import agentsmobiles.commun.*;
import agentsmobiles.server.AgentServer;

public class LancerCompress {
    public static void main(String[] args) {
        // Usage : java agentsmobiles.client.LancerCompress <IP_SERVEUR_FICHIER>
        String serverIp = "localhost";
        if (args.length >= 1) {
            serverIp = args[0];
        }

        // Port 5001 pour ce client
        new Thread(new AgentServer(5001)).start();

        try {
            Thread.sleep(1000); // attendre que le serveur local soit prêt
            // Récupération automatique de mon ip pour le retour
            String myIp = java.net.InetAddress.getLocalHost().getHostAddress();

            CompressAgent agent = new CompressAgent();
            // Init : nom + origine
            agent.init("AgentZip", new Node(myIp, 5001));
            agent.setServerNode(new Node(serverIp, 4000));
            
            new Thread(agent).start();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
