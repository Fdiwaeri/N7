import java.util.Random;

public aspect DebitEleve {
    private final double LIMITE = 450;
    private Random random = new Random();
    
    pointcut debitImportant(CompteSimple cs, double m) :
        target(cs) && args(m) && call(void *.debiter(double));

    void around(CompteSimple cs, double m) : debitImportant(cs, m) {
        boolean ok = true;
        if (m > LIMITE) {
            System.out.println("Envoi de SMS pour confirmer : débit de " + m + " euros");
            ok = random.nextInt(10) <= 2;
        }
        try {
            if (ok) {
                proceed(cs, m);
            } else {
                System.out.println("Opération non confirmé => DEBIT REFUSE");
                throw new OperationNonConfirmeeException("Debit supérieur à " + LIMITE + "euros");
            }
        } catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
}