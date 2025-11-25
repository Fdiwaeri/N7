import java.util.HashMap;

/**
  * Exemples d'affichage d'expressions arithmétiques
  *
  * @author	Xavier Crégut & F.E
  */

public class ExemplesAffichage {

	static final private OperateurBinaire plus = new Addition();
	static final private OperateurBinaire moins = new Soustraction();
	static final private OperateurBinaire fois = new Multiplication();
	static final private OperateurUnaire negation = new Negation();

	static public Expression expression1() {
		return new ExpressionUnaire(negation,
					new ExpressionBinaire(fois,
						new Constante(2),
						new ExpressionBinaire(plus,
							new Constante(1),
							new AccesVariable("x"))));
	}

	static public Expression expression2() {
		return new ExpressionBinaire(plus,
					new Constante(5),
					new ExpressionBinaire(fois,
							new AccesVariable("x"),
							new Constante(4)));
	}

	// Une expression pour tester la soustraction
	static public Expression expression3() {
		return new ExpressionBinaire(moins,
					new Constante(5),
					new Constante(4));
	}

	// Une expression pour tester la définition de variable
	static public Expression expression4() {
		return new DefVariable("x",
					new Constante(5),
					new ExpressionBinaire(plus,
							new Constante(2),
							new AccesVariable("x")));
	}

	public static void main(String[] args) {
		// Afficheur Infixe :
		System.out.println("Afficheur Infixe :");
		// Afficher expression 1
		AfficheurInfixe infixe = new AfficheurInfixe();
		String e1infixe = expression1().accepter(infixe);
		System.out.println("e1 = " + e1infixe);

		// Afficher expression2
		String e2infixe = expression2().accepter(infixe);
		System.out.println("e2 = " + e2infixe);

		// Afficher expression3
		String e3infixe = expression3().accepter(infixe);
		System.out.println("e3 = " + e3infixe);

		// Afficher expression4
		String e4infixe = expression4().accepter(infixe);
		System.out.println("e4 = " + e4infixe);


		// Afficheur Postfixe :
		System.out.println(); System.out.println("Afficheur Postfixe :");
		// Afficher expression 1
		AfficheurPostfixe postfixe = new AfficheurPostfixe();
		String e1postfixe = expression1().accepter(postfixe);
		System.out.println("e1 = " + e1postfixe);

		// Afficher expression2
		String e2postfixe = expression2().accepter(postfixe);
		System.out.println("e2 = " + e2postfixe);

		// Afficher expression3
		String e3postfixe = expression3().accepter(postfixe);
		System.out.println("e3 = " + e3postfixe);

		// Afficher expression4
		String e4postfixe = expression4().accepter(postfixe);
		System.out.println("e4 = " + e4postfixe);


		// CalculHauteur :
		System.out.println(); System.out.println("Calcul Hauteur :");
		// Afficher expression 1
		CalculHauteur hauteur = new CalculHauteur();
		Integer e1hauteur = expression1().accepter(hauteur);
		System.out.println("e1 = " + e1hauteur);

		// Afficher expression2
		Integer e2hauteur = expression2().accepter(hauteur);
		System.out.println("e2 = " + e2hauteur);

		// Afficher expression3
		Integer e3hauteur = expression3().accepter(hauteur);
		System.out.println("e3 = " + e3hauteur);

		// Afficher expression4
		Integer e4hauteur = expression4().accepter(hauteur);
		System.out.println("e4 = " + e4hauteur);


		// EvaluateurExpression :
		System.out.println(); System.out.println("Evaluateur Expression :");
		HashMap<String, Integer> environnement = new HashMap<String, Integer>();
		environnement.put("x", 3); // x = 3
		// Afficher expression 1
		EvaluateurExpression valeur = new EvaluateurExpression(environnement);
		Integer e1valeur = expression1().accepter(valeur);
		System.out.println("e1 = " + e1valeur);

		// Afficher expression2
		Integer e2valeur = expression2().accepter(valeur);
		System.out.println("e2 = " + e2valeur);

		// Afficher expression3
		Integer e3valeur = expression3().accepter(valeur);
		System.out.println("e3 = " + e3valeur);

		// Afficher expression4
		Integer e4valeur = expression4().accepter(valeur);
		System.out.println("e4 = " + e4valeur);


		// Afficheur Infixe Minimal :
		System.out.println(); System.out.println("Afficheur Infixe Minimal :");
		// Afficher expression 1
		AfficheurInfixeMinimal infixeMin = new AfficheurInfixeMinimal();
		String e1infixeMin = expression1().accepter(infixeMin);
		System.out.println("e1 = " + e1infixeMin);

		// Afficher expression2
		String e2infixeMin = expression2().accepter(infixeMin);
		System.out.println("e2 = " + e2infixeMin);

		// Afficher expression3
		String e3infixeMin = expression3().accepter(infixeMin);
		System.out.println("e3 = " + e3infixeMin);

		// Afficher expression4
		String e4infixeMin = expression4().accepter(infixeMin);
		System.out.println("e4 = " + e4infixeMin);
	}
}

