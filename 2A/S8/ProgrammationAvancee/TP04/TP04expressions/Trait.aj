public aspect Trait {
    public abstract int Expression.nbTraits();

    public abstract int OperateurUnaire.nbTraits();

    public abstract int OperateurBinaire.nbTraits();

    public int AccesVariable.nbTraits(){
        return 0;
    }

    public int Constante.nbTraits(){
        return 0;
    }

    public int Negation.nbTraits(){
        return 1;
    }

    public int Addition.nbTraits(){
        return 2;
    }

    public int Multiplication.nbTraits(){
        return 3;
    }

    public int ExpressionUnaire.nbTraits(){
        return this.getOperateur().nbTraits() + this.getOperande().nbTraits();
    }

    public int ExpressionBinaire.nbTraits(){
        return this.getOperandeGauche().nbTraits()
            + this.getOperandeDroite().nbTraits()
            + this.getOperateur().nbTraits();
    }
}