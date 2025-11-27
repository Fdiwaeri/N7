import java.lang.reflect.*;
import java.util.*;

/** L'objectif est de faire un lanceur simple sans utiliser toutes les clases
  * de notre architecture JUnit.   Il permet juste de valider la compréhension
  * de l'introspection en Java.
  */
public class LanceurIndependant {
	private int nbTestsLances;
	private int nbErreurs;
	private int nbEchecs;
	private List<Throwable> erreurs = new ArrayList<>();

	public LanceurIndependant(String... nomsClasses) {
	    System.out.println();

		// Lancer les tests pour chaque classe
		for (String nom : nomsClasses) {
			try {
				System.out.print(nom + " : ");
				this.testerUneClasse(nom);
				System.out.println();
			} catch (ClassNotFoundException e) {
				System.out.println(" Classe inconnue !");
			} catch (Exception e) {
				System.out.println(" Problème : " + e);
				e.printStackTrace();
			}
		}

		// Afficher les erreurs
		for (Throwable e : erreurs) {
			System.out.println();
			e.printStackTrace();
		}

		// Afficher un bilan
		System.out.println();
		System.out.printf("%d tests lancés dont %d échecs et %d erreurs.\n",
				nbTestsLances, nbEchecs, nbErreurs);
	}


	public int getNbTests() {
		return this.nbTestsLances;
	}


	public int getNbErreurs() {
		return this.nbErreurs;
	}


	public int getNbEchecs() {
		return this.nbEchecs;
	}


	private void testerUneClasse(String nomClasse)
		throws ClassNotFoundException, InstantiationException,
						  IllegalAccessException
	{
		// Récupérer la classe
		Class<?> classe = Class.forName(nomClasse);

		// Récupérer les méthodes "preparer" et "nettoyer"
		Method preparer = null;
		Method nettoyer = null;
		try{
			preparer = classe.getMethod("preparer");
		} catch (NoSuchMethodException e){}
		try{
			nettoyer = classe.getMethod("nettoyer");
		} catch (NoSuchMethodException e){}

		// Instancier l'objet qui sera le récepteur des tests
		Object objet = null;
		try{
			objet = classe.getConstructor().newInstance();
		} catch (NoSuchMethodException | InvocationTargetException e){
			throw new InstantiationException("Impossible d'instancier la classe de test");
		}

		// Exécuter les méthods de test
		Method[] methodes = classe.getMethods(); // Pour récupérer toutes les méthodes publiques, y compris celles de l'héritage.
		for (Method m : methodes) {
			if (m.getName().startsWith("test") && !Modifier.isStatic(m.getModifiers())
				&& Modifier.isPublic(m.getModifiers()) && m.getParameterCount() == 0) {
				nbTestsLances++;
				try {
					if (preparer != null){
						preparer.invoke(objet);
					}
					m.invoke(objet);
					if (nettoyer != null){
						nettoyer.invoke(objet);
					}
					System.out.print(".");
				} catch (InvocationTargetException e){
					Throwable cause = e.getCause();
					if (cause instanceof Echec) {
						nbEchecs++;
						System.out.print("F");
					} else {
						nbErreurs++;
						System.out.print("E");
						erreurs.add(cause);
					}
					
				} catch (Exception e) { // Problème technique lors de l'appel (ex: accès illégal)
                    System.out.print("E");
                    nbErreurs++;
                    erreurs.add(e);
                }
			}
		}
	}

	public static void main(String... args) {
		LanceurIndependant lanceur = new LanceurIndependant(args);
	}

}
