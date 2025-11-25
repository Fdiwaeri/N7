/**
  * Définition de variable par let ident = E in E
  *
  * @author	F.E
  */
public class DefVariable implements Expression {

	private AccesVariable ident;
	private Expression expression1;
    private Expression expression2;

	public DefVariable(String identifiant, Expression expression1, Expression expression2)
	{
		this.ident = new AccesVariable(identifiant);
		this.expression1 = expression1;
		this.expression2 = expression2;
	}

	public AccesVariable getident() {
		return this.ident;
	}

	public Expression getExpressionVariable() {
		return this.expression1;
	}

	public Expression getExpression() {
		return this.expression2;
	}

	public <R> R accepter(VisiteurExpression<R> visiteur) {
		return visiteur.visiterDefVariable(this);
	}

}
