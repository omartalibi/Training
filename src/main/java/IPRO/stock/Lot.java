package IPRO.stock;

public class Lot implements Sellable{
    private String name;
    private String reference;
    private int quantity;
    private Article article;
    private float discount;

    public Lot(String reference, Article article, int quantity, float discount){
        this.reference = reference;
        this.quantity = quantity;
        this.article =  article;
        this.name = "Lot de "  + quantity + " " + article.getName() + " " + article.getType();
    }

    @Override
    public String getReference() {
        return reference;
    }

    @Override
    public float getPrix() {
        return quantity*article.getPrix() - quantity*article.getPrix() * discount/100;
    }

    @Override
    public String getName(){
        return name;
    }

    public Article getArticle(){
        return article;
    }

    public int getQuantity(){
        return quantity;
    }


}
