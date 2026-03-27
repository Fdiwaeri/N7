import java.io.*;
import java.util.*;

/** Analyser des données d'un fichier, une donnée par ligne avec 4 informations
 * séparées par des blancs : x, y, ordre (ignorée), valeur.
 */
public class Analyseur {
	/** Conserve la somme des valeurs associées à une position. */
	private Map<Position, Double> cumuls;
	/** Nom des fichiers à analyser. */
	private String[] nomsFichiers = {"donnees-f2.txt", "donnees.txt", "donnees2.txt"};

	/** Construire un analyseur vide. */
	public Analyseur() {
		cumuls = new HashMap<>();
	}

	/** Charger l'analyseur avec les données du fichier "donnees.java". */
	public void charger() {
		int longueurMots;
		int posX;
		int posY;
		int posV;
		for (String fichier : nomsFichiers) {
			Map<Position, Double> old = new HashMap<>(cumuls);
			if (fichier.substring(fichier.length()-7).equals("-f2.txt")) {
				longueurMots = 5;
				posX = 1;
				posY = 2;
				posV = 4;
			} else {
				longueurMots = 4;
				posX = 0;
				posY = 1;
				posV = 3;
			}
			try (BufferedReader in = new BufferedReader(new FileReader(fichier))) {
				String ligne = null;
				while ((ligne = in.readLine()) != null) {
					String[] mots = ligne.split("\\s+");
					assert mots.length == longueurMots;	// 4 ou 5 mots sur chaque ligne
					int x = Integer.parseInt(mots[posX]);
					int y = Integer.parseInt(mots[posY]);
					Position p = new Position(x, y);
					double valeur = Double.parseDouble(mots[posV]);
					if (valeur>=0){
					cumuls.put(p, valeur(p) + valeur);
					// p.setY(p.getY() + 1);	//  p.y += 1;
					} else{
						throw new MalformedFileException(fichier);
					}
				}
			} catch (MalformedFileException e) {
				System.out.println("Erreur dans un fichier mal rédigé :");
				System.out.println(e.getMessage());
				this.cumuls = old;
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/** Obtenir la valeur associée à une position. */
	public double valeur(Position position) {
		Double valeur = cumuls.get(position);
		return valeur == null ? 0.0 : valeur;
	}

	/** Obtenir toutes les données. */
	public Map<Position, Double> donnees() {
		return Collections.unmodifiableMap(this.cumuls);
	}

	/** Affichier les données. */
	public static void main(String[] args) {
		Analyseur a = new Analyseur();
		a.charger();
		System.out.println(a.donnees());
		System.out.println("Nombres de positions : " + a.donnees().size());
	}
}
