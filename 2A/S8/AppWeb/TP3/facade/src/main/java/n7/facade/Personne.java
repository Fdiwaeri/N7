package n7.facade;

import java.util.ArrayList;
import java.util.Collection;;

public class Personne {
    int id;
    String nom;
    String prenom;
    Collection<Adresse> adresses = new ArrayList<Adresse>();

    public Personne(int vid, String vnom, String vprenom){
        id = vid;
        nom = vnom;
        prenom = vprenom;
    }

    public int getId() {return id;}
    public String getNom(){return nom;}
    public String getPrenom(){return prenom;}
    public Collection<Adresse> getAdresses(){return adresses;}

    public void setId(int id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setAdresses(Collection<Adresse> adresses) {
        this.adresses = adresses;
    }


    public void ajoutAdresse(Adresse a){
        this.adresses.add(a);
    }

}
