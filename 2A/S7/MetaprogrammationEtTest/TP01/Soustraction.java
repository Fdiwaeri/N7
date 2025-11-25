/**
  * Opérateur binaire de soustraction.
  *
  * @author	F.E
  */
public class Soustraction implements OperateurBinaire {

	public <R> R accepter(VisiteurExpression<R> visiteur) {
		return visiteur.visiterSoustraction(this);
	}

}
