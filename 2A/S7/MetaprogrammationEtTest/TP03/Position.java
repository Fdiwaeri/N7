import java.util.Objects;
import lombok.Value;
// Au lieu de value, on peur utiliser Data et déclarer les attributs
// constants (final). On utilise aussi @AllArgsConstructor pour générer
// un constructeur qui prend autant d'arguments que d'attributs.
// import lombok.Data;
// import lombok.AllArgsConstructor;

/** Définir une position.  */
@Value
///@Data
//@AllArgsConstructor
public class Position {
	public int x;
	public int y;

	@Override public String toString() {
		return super.toString() + "(" + x + "," + y + ")";
	}

}
