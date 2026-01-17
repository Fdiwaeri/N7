package agentsmobiles.client;

import agentsmobiles.commun.*;
import agentsmobiles.server.AgentServer;

public class LancerHotel {
    public static void main(String[] args) {
        // java agentsmobiles.client.LancerHotel <IP_SERVEUR_A> <IP_SERVEUR_B>
        
        String ipA = "localhost"; // valeur par défaut
        String ipB = "localhost";
        
        if (args.length >= 2) {
            ipA = args[0];
            ipB = args[1];
        }

        // Le client écoute sur le port 5000
        new Thread(new AgentServer(5000)).start();

        try {
            Thread.sleep(5000); // attendre que le serveur local soit prêt
            HotelAgent agent = new HotelAgent();

            String myIp = java.net.InetAddress.getLocalHost().getHostAddress();
            agent.init("HotelAgent", new Node(myIp, 5000));

            agent.setItinerary(new Node(ipA, 2000), new Node(ipB, 3000));

            new Thread(agent).start();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
