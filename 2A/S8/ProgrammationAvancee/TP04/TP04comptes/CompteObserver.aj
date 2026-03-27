import java.util.*;

public aspect CompteObserver {
    declare parents : CompteSimple extends Observable;

    private void CompteSimple.avertir(double montant) {
        this.setChanged();
        this.notifyObservers(montant);
    }

    pointcut changeSolde(CompteSimple cs, double m) :
        target(cs) && args(m) && 
        (call (void CompteSimple.crediter(double)) || call (void CompteSimple.debiter(double)));

    after(CompteSimple cs, double m) : changeSolde(cs, m) {
        String nomMethode = thisJoinPoint.getSignature().getName();
        int facteur = (nomMethode.equals("crediter")) ? 1 : -1 ;
        cs.avertir(facteur * m);
    }

}