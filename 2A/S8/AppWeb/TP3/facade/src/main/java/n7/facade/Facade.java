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
    public void addPersonne(Personne p) {
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
    public void addAdresse(Adresse a) {
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
}