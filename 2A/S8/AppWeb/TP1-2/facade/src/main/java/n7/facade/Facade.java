package n7.facade;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import org.springframework.web.bind.annotation.*;

@RestController
public class Facade {
    private Map<Integer ,Personne> personnes = new Hashtable<>();
    private Map<Integer ,Adresse> adresses = new Hashtable<>();
    
    @PostMapping ("/addp")
    public void addPersonne( @RequestParam("nom") String nom, @RequestParam("prenom") String prenom) {
        int i = personnes.size() +1;
        Personne p = new Personne(i, nom, prenom);
        personnes.put(p.getId(), p);
    }

    @GetMapping ("/consulterps")
    public Collection<Personne> consulterPersonnes() {
        return personnes.values();
    }

    @GetMapping ("/consulterp")
    public Personne consulterPersonne ( @RequestParam("num") int num ) {
        Personne p = personnes.get(num) ;
        if ( p == null )
            throw new RuntimeException("Compte introuvable") ;
        return p ;
    }

    @PostMapping ("/adda")
    public void addAdresse(String rue, String ville) {
        int i = adresses.size() + 1;
        Adresse a = new Adresse(i, rue, ville);
        adresses.put(a.getId(), a);
    }

    @GetMapping ("/consulteras")
    public Collection<Adresse> consulterAdresses() {
        return adresses.values();
    }

    @GetMapping ("/consultera")
    public Adresse consulterAdresse ( @RequestParam("num") int num ) {
        Adresse a = adresses.get(num) ;
        if ( a == null )
            throw new RuntimeException("Compte introuvable") ;
        return a ;
    }

    @PostMapping("/associer")
    public void associer(@RequestParam("idp") int idp, @RequestParam("ida") int ida){
        Personne p = personnes.get(idp);
        Adresse a = adresses.get(ida);
        p.ajoutAdresse(a);
        personnes.put(idp, p);
    }
}