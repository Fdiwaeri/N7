/** Afficheur infixe, complètement parenthésé, d'une expression arithmétique.
  *
  * @author	Xavier Crégut
  * @version	$Revision$
  */
public class AfficheurInfixe implements VisiteurExpression<String> {

	public String visiterAccesVariable(AccesVariable v) {
		return "(" + v.getNom() + ")";
	}

	public String visiterDefVariable(DefVariable e) {
		return "(let " + e.getident().accepter(this) + " = "
			+ e.getExpressionVariable().accepter(this) + " in "
			+ e.getExpression().accepter(this) +  ")";
	}

	public String visiterConstante(Constante c) {
		return "(" + String.valueOf(c.getValeur()) + ")";
	}

	public String visiterExpressionBinaire(ExpressionBinaire e) {
		return "(" + e.getOperandeGauche().accepter(this)
			+ " " + e.getOperateur().accepter(this)
			+ " " + e.getOperandeDroite().accepter(this)
			+ ")" ;
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
		return "(" + e.getOperateur().accepter(this)
			+ " " + e.getOperande().accepter(this) + ")";
	}

	public String visiterNegation(Negation n) {
		return "-";
	}

}
