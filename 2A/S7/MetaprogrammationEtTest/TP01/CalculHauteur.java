/** CalculHauteur calcule la hauteur de l’arbre d’une expression arithmétique.
  *
  * @author	F.E
  */
public class CalculHauteur implements VisiteurExpression<Integer> {

	public Integer visiterAccesVariable(AccesVariable v) {
		return 1;
	}

	public Integer visiterDefVariable(DefVariable e) {
		return 1 + Integer.max(e.getExpressionVariable().accepter(this),
			e.getExpression().accepter(this));
	}

	public Integer visiterConstante(Constante c) {
		return 1;
	}

	public Integer visiterExpressionBinaire(ExpressionBinaire e) {
		return 1 + Integer.max(e.getOperandeGauche().accepter(this),
            e.getOperandeDroite().accepter(this));
	}

	public Integer visiterAddition(Addition a) {
		return 0;
	}

    public Integer visiterSoustraction(Soustraction s) {
		return 0;
	}

	public Integer visiterMultiplication(Multiplication m) {
		return 0;
	}

	public Integer visiterExpressionUnaire(ExpressionUnaire e) {
		return 1 + e.getOperande().accepter(this);
	}

	public Integer visiterNegation(Negation n) {
		return 0;
	}

}
