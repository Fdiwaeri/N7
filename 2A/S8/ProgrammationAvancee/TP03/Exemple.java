import java.lang.reflect.Proxy;
import java.util.*;

public class Exemple {
    public static void main(String[] args) {
        List<Integer> liste = new ArrayList<>();
        Collections.addAll(liste, 2, 3, 5, 7);
        System.out.println("liste = " + liste);
        liste.remove(2);
        System.out.println("liste = " + liste);
        String[] methodesInterdites = {"add", "remove"};
        ProtectionHandler ph = new ProtectionHandler(liste, methodesInterdites);
        List<Integer> liste2 = (List<Integer>)
            Proxy.newProxyInstance(List.class.getClassLoader(),
                                   new Class[] {List.class},
                                   ph);
        System.out.println("liste2 = " + liste2);                        
        try{
            liste2.add(6);
        } catch (Exception e) {
            System.out.println("impossible d'ajouter un elt à liste2");
        }
        try{
            liste2.remove(0);
        } catch (Exception e) {
            System.out.println("impossible de supprimer un elt à liste2");
        }
        System.out.println("liste2 = " + liste2);

        System.out.println("\nLa partie map : \n");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "fr");
        System.out.println("map = " + map);
        map.clear();
        System.out.println("map = " + map);
        map.put(1, "fr");
        map.put(2, "eng");
        map.put(3, "esp");
        System.out.println("map = " + map);
        Map<Integer, String> map2 = (Map<Integer, String>)
            Proxy.newProxyInstance(Map.class.getClassLoader(),
            new Class[] { Map.class }, 
            new ProtectionHandler(map, new String[] {"put", "clear"}));
        System.out.println("map2 = " + map2);
        try{
            map2.clear();
        } catch (Exception e) {
            System.out.println("Impossible d'utiliser clear sur map2");
        }
        try{
            map2.put(4, "arb");
        } catch (Exception e) {
            System.out.println("Impossible d'utiliser put sur map2");
        }
        System.out.println("map2 = " + map2);
    }
}
