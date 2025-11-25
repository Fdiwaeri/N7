import java.util.HashMap;

/** Evaluateur Expression calcule la valeur d'une expression arithmétique.
  *
  * @author	F.E
  */
public class EvaluateurExpression implements VisiteurExpression<Integer> {
    private HashMap<String, Integer> env;

    /** Construire un visiteur EvaluateurExpression à partie d'un
     * environnement dans lequel on stocke les valeurs des variables.
     * @param environnement les valeurs des variables
     */
    public EvaluateurExpression(HashMap<String, Integer> environnement) {
        this.env = environnement;
    }

	public Integer visiterAccesVariable(AccesVariable v) {
		String nomVariable = v.getNom();
        if (env.containsKey(nomVariable)) {
            return env.get(nomVariable);
        } else {
            throw new RuntimeException("Variable non définie dans l'environnement : " + nomVariable);
        }
	}

    public Integer visiterDefVariable(DefVariable e) {
        this.env.put(e.getident().getNom(), e.getExpressionVariable().accepter(this));
		return e.getExpression().accepter(this);
	}

	public Integer visiterConstante(Constante c) {
		return c.getValeur();
	}

	public Integer visiterExpressionBinaire(ExpressionBinaire e) {
		Integer numOp = e.getOperateur().accepter(this);
        if (numOp == 1){ // Addition
            return e.getOperandeGauche().accepter(this)
                + e.getOperandeDroite().accepter(this);
        } else if (numOp == 2){ // Soustraction
            return e.getOperandeGauche().accepter(this)
                - e.getOperandeDroite().accepter(this);
        } else { // Multiplication
            return e.getOperandeGauche().accepter(this)
                * e.getOperandeDroite().accepter(this);
        }
	}

	public Integer visiterAddition(Addition a) {
		return 1;
	}

	public Integer visiterSoustraction(Soustraction s) {
		return 2;
	}

	public Integer visiterMultiplication(Multiplication m) {
		return 3;
	}

	public Integer visiterExpressionUnaire(ExpressionUnaire e) {
		return (-1) * e.getOperande().accepter(this);
	}

	public Integer visiterNegation(Negation n) {
		return 0;
	}

}
