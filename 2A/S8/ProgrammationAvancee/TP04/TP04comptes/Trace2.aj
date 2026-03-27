public aspect Trace2 {
    pointcut allPublicMethods() :
        call (public (CompteSimple||CompteCourant).new(..))
        || call (public * (CompteSimple||CompteCourant).*(..));

    before() : allPublicMethods() {
        String message = "";
        String nomClasse = thisJoinPoint.getSignature().getDeclaringTypeName();
        String nomMethode = thisJoinPoint.getSignature().getName();
        if (nomMethode == "<init>") {
            message += "new " + nomClasse;
        } else {
            message += nomClasse + "." + nomMethode;
        }
        message += "(";
        boolean premier = true;
        for (Object arg : thisJoinPoint.getArgs()) {
            if (!premier){
                message += ", ";
            } else {
                premier = false;
            }
            message += arg;
        }
        message += ")";
        System.out.println("Appel à : " + message );
    }
}