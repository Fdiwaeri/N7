package agentsmobiles.server;

import agentsmobiles.commun.*;

public class AgentClassLoader extends ClassLoader {
    private String className;
    private byte[] classBytes;

    public AgentClassLoader(String className, byte[] classBytes) {
        this.className = className;
        this.classBytes = classBytes;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // si c'est la classe de l'agent qu'on a reçu on la définit manuellement
        if (name.equals(this.className)) {
            return defineClass(name, classBytes, 0, classBytes.length);
        }
        return super.findClass(name);
    }
}
