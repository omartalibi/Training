package IPRO.cours.stock;

public abstract class Article implements Sellable{
    private String reference;
    private String name;
    private String marque;
    private float prixUnitaire;
    private String type;

    Article(String reference, String name, String marque, String type, float prixUnitaire){
        this.reference = reference;
        this.name = name;
        this.marque = marque;
        this.type =type;
        this.prixUnitaire =prixUnitaire;
    }

    @Override
    public String getReference() {
        return reference;
    }

    @Override
    public float getPrix() {
        return prixUnitaire;
    }

    @Override
    public String getName(){
        return name;
    }

    public String getMarque(){
        return marque;
    }

    public String getType(){
        return type;
    }

}
