package cours.stock;

public class Stylo extends Article {
    private Couleur couleur;


    public Stylo(String reference, String name, String marque, String type, float prixUnitaire, Couleur couleur) {
        super(reference, name, marque, type, prixUnitaire);
        this.couleur = couleur;
    }
}
