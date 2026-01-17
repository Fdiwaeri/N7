package agentsmobiles.commun;

import java.io.Serializable;

public class Node implements Serializable {
    private String host;
    private int port;

    public Node(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }
    
    public int getPort() {
        return port;
    }
}
