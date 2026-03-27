package pack;

public class Adresse {
    private int id;
    private String rue;
    private String ville;

    public Adresse(int id, String rue, String ville) {
        this.id = id;
        this.rue = rue;
        this.ville = ville;
    }

    public int getId() { return id; }
    public String getRue() { return rue; }
    public String getVille() { return ville; }

    public void setId(int vid) { id = vid; }
    public void setRue(String vrue) { rue = vrue; }
    public void setVille(String vville) { ville = vville; }

}