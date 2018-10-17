package cours.stock;

public class Ream extends Article{

    private String grammage;


    public Ream(String reference, String name, String marque, String type, float prixUnitaire, String grammage) {
        super(reference, name, marque, type, prixUnitaire);
        grammage = this.grammage;
    }
}
