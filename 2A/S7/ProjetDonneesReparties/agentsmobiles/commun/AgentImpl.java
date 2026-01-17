package agentsmobiles.commun;

import java.io.*;
import java.net.Socket;
import java.util.Hashtable;

public abstract class AgentImpl implements Agent, Runnable {
    protected String name;
    protected Node origin;
    protected Node currentPlace;
    private transient Hashtable<String, Object> nameServer; // transient car local au serveur

    public void init(String name, Node origin) {
        this.name = name;
        this.origin = origin;
        this.currentPlace = origin;
    }

    public void setNameServer(Hashtable<String, Object> ns) {
        this.nameServer = ns; 
    }
    
    public Hashtable<String, Object> getNameServer() {
        return nameServer; 
    }

    // Pour permettre l'exécution dans un thread
    public void run() {
        try {
            main(); 
        } catch (MoveException e) {
            e.printStackTrace();
        }
    }

    public void move(Node target) throws MoveException {
        try {
            System.out.println("Déplacement de " + name + " vers " + target.getPort());
            Socket socket = new Socket(target.getHost(), target.getPort());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            // 1) Envoi du nom de la classe
            String className = this.getClass().getName();
            out.writeObject(className);

            // 2) Envoi du code (.class)
            String classResource = "/" + className.replace('.', '/') + ".class";
            InputStream is = this.getClass().getResourceAsStream(classResource);
            if (is == null) throw new MoveException("Code de la classe introuvable");
            
            byte[] classBytes = is.readAllBytes();
            out.writeObject(classBytes); // On envoie le tableau d'octets du code

            // 3) Envoi des données (L'état de l'objet agent)
            this.currentPlace = target; // mise à jour avant départ
            out.writeObject(this);

            out.close();
            socket.close();

            // Arrêt de l'exécution sur le noeud de départ
            // L'agent est détruit sur le site d'origine
            Thread.currentThread().interrupt(); 
            throw new MoveException("Agent migré - Arrêt local"); 
            
        } catch (IOException e) {
            throw new MoveException("Erreur migration: " + e.getMessage());
        }
    }

    public void back() throws MoveException {
        move(origin); 
    }
}
