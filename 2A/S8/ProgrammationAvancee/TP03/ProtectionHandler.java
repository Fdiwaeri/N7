import java.lang.reflect.*;
import java.util.*;

public class ProtectionHandler implements InvocationHandler {
    private Object monObjet;
    private List<String> methodesInterdites = new ArrayList<>();

    public ProtectionHandler(Object obj, String[] nomsMethodes) {
        monObjet = obj;
        Collections.addAll(methodesInterdites, nomsMethodes);
    }

    public Object invoke(Object obj, Method methode, Object[] params) throws Throwable {
        if (methodesInterdites.contains(methode.getName())) {
            throw new UnsupportedOperationException();
        }
        return methode.invoke(monObjet, params);
    }
}