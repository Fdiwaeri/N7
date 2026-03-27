import java.io.IOException;

public class MalformedFileException extends IOException {
    private String nomFichier;

    public MalformedFileException(String nomFichier) {
      this.nomFichier = nomFichier;
   }

   public String getInputLength() {
      return this.nomFichier;
   }

   public String getMessage() {
      return "Nom du fichier = " + this.nomFichier;
   }
}
