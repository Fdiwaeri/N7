public aspect Trace {
    pointcut allPublicMethods() :
        call (public (CompteSimple||CompteCourant).new(..))
        || call (public * (CompteSimple||CompteCourant).*(..));

    before() : allPublicMethods() {
        System.out.println("Trace : " + thisJoinPoint.getSignature());
    }

}