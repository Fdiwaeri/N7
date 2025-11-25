/** Afficheur infixe Minimal utilisant seulement les parenthèses nécessaires.
  *
  * @author	F.E
  */
public class AfficheurInfixeMinimal extends AfficheurInfixe implements VisiteurExpression<String> {

    // Obtenir la priorité d'un noeud
    // param noeud le noeud
    private int getPriorite(Object o) {
        if (o instanceof ExpressionBinaire) {
            return getPriorite(((ExpressionBinaire) o).getOperateur());
        }
        if (o instanceof ExpressionUnaire) {
            return getPriorite(((ExpressionUnaire) o).getOperateur());
        }
        if (o instanceof Constante || o instanceof AccesVariable) { return 4;}
        if (o instanceof Negation) { return 3;}
        if (o instanceof Multiplication) { return 2;}
        if (o instanceof Addition || o instanceof Soustraction) { return 1;}
        if (o instanceof DefVariable) { return 0;}
        return 0;
    }

	public String visiterAccesVariable(AccesVariable v) {
		return v.getNom();
	}

	public String visiterDefVariable(DefVariable e) {
		return "let " + e.getident().accepter(this) + " = "
			+ e.getExpressionVariable().accepter(this) + " in "
			+ e.getExpression().accepter(this);
	}

	public String visiterConstante(Constante c) {
		return String.valueOf(c.getValeur());
	}

	public String visiterExpressionBinaire(ExpressionBinaire e) {
		int prioPere = getPriorite(e.getOperateur());
        int prioGauche = getPriorite(e.getOperandeGauche());
        String partieG;
        int prioDroite = getPriorite(e.getOperandeDroite());
        String partieD;

        if (prioGauche < prioPere) {
            partieG = "(" + e.getOperandeGauche().accepter(this) + ")";
        } else {
            partieG = e.getOperandeGauche().accepter(this);
        }

        if (prioDroite <= prioPere) {
            partieD = "(" + e.getOperandeDroite().accepter(this) + ")";
        } else {
            partieD = e.getOperandeDroite().accepter(this);
        }
        
        return partieG + " " + e.getOperateur().accepter(this)
			+ " " + partieD;
	}

	public String visiterExpressionUnaire(ExpressionUnaire e) {
		int prioPere = getPriorite(e.getOperateur());
        int prioOperande = getPriorite(e.getOperande());
        String partieOperande;
        if (prioOperande < prioPere) {
            return e.getOperateur().accepter(this)
			+ " (" + e.getOperande().accepter(this) + ")";
        }
        
        return e.getOperateur().accepter(this)
			+ " " + e.getOperande().accepter(this);
	}

}
