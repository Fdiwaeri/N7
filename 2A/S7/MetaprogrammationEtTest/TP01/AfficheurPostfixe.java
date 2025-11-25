/** Afficheur postfixe, notation polonaise inverse, d'une expression arithmétique.
  *
  * @author	F.E
  */
public class AfficheurPostfixe implements VisiteurExpression<String> {

	public String visiterAccesVariable(AccesVariable v) {
		return v.getNom();
	}

	public String visiterDefVariable(DefVariable e) {
		return e.getExpressionVariable().accepter(this) +  " " 
			+ e.getident().accepter(this) + " ni "
			+ e.getExpression().accepter(this) +  " tel";
	}

	public String visiterConstante(Constante c) {
		return String.valueOf(c.getValeur());
	}

	public String visiterExpressionBinaire(ExpressionBinaire e) {
		return e.getOperandeGauche().accepter(this)
            + " " + e.getOperandeDroite().accepter(this)
			+ " " + e.getOperateur().accepter(this);
	}

	public String visiterAddition(Addition a) {
		return "+";
	}

	public String visiterSoustraction(Soustraction s) {
		return "-";
	}

	public String visiterMultiplication(Multiplication m) {
		return "*";
	}

	public String visiterExpressionUnaire(ExpressionUnaire e) {
		return e.getOperande().accepter(this)
			+ " " + e.getOperateur().accepter(this);
	}

	public String visiterNegation(Negation n) {
		return "~";
	}

}
