public class Exemple {
    public static void main(String[] args) {
        OperateurUnaire moins = new Negation();
        Expression e1 = new Constante(0); // 0
        Expression e2 = new ExpressionUnaire(moins, new Constante(1)); // -1

        AccesVariable x = new AccesVariable("x");
        Expression e3 = new ExpressionUnaire(moins, x); // -x

        Constante un = new Constante(1);
        Constante deux = new Constante(2);
        OperateurBinaire plus = new Addition();
        OperateurBinaire fois = new Multiplication();
        Expression e4 = new ExpressionBinaire(plus, un, deux); // 1 + 2
        Expression e5 = new ExpressionBinaire(fois, deux, e4); // 2 * (1 + 2)

        // (x + (-1)) * ((2 + x) * (-x))
        Expression e6 = new ExpressionBinaire(fois,
            new ExpressionBinaire(plus, x, new ExpressionUnaire(moins, un)),
            new ExpressionBinaire(fois, 
                new ExpressionBinaire(plus, deux, x), 
                new ExpressionUnaire(moins, x)));

        System.out.println("e1 = 0 : " + e1.nbTraits());
        System.out.println("e2 = -1 : " + e2.nbTraits());
        System.out.println("e3 = -x : " + e3.nbTraits());
        System.out.println("e4 = 1+2 : " + e4.nbTraits());
        System.out.println("e5 = 2 * (1 + 2) : " + e5.nbTraits());
        System.out.println("e6 = (x + (-1)) * ((2 + x) * (-x)) : " + e6.nbTraits());
    }
}