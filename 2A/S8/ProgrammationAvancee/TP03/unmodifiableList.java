import java.util.*;

public class unmodifiableList {
    public static void main(String[] args) {
        List<Integer> liste = new ArrayList<>();
        Collections.addAll(liste, 2, 3, 5, 7);
        System.out.println("liste = " + liste);
        liste.remove(2);
        System.out.println("liste = " + liste);
        List<Integer> liste2 = Collections.unmodifiableList(liste);
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
    }
}