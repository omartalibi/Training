package IPRO.projet.application;

import IPRO.projet.typage.*;

import java.io.IOException;

import static IPRO.projet.metier.SellableReductionProvider.*;
import static IPRO.projet.typage.Prix.*;
import static IPRO.projet.typage.Reduction.Reduction;

public class Lot implements ISellable{
    private Reference reference;
    private Name nom;
    private Prix prix;
    private Article article;
    private Quantity quantity;

    private String type;

    public Lot(Reference reference, Name nom, Article article, Quantity quantity, String type) throws IOException {
        this.reference = reference;
        this.nom = nom;
        this.article = article;
        this.quantity = quantity;

        this.prix = calculatePrix();

        this.type = type;
    }



    @Override
    public Reference getReferenceObject() {
        return reference;
    }

    @Override
    public Name getNameObject() {
        return nom;
    }

    @Override
    public Prix getPrixObject() {
        return prix;
    }


    /** Reduction sur l'article puis taux de remise sur le lot*/
    private Prix calculatePrix() throws IOException {
        Prix articlePrixObject = article.getPrixObject();
        Double prix_lot = articlePrixObject.getPrixValue() * quantity.getQuantityValue();
        return Prix(prix_lot);
    }


    @Override
    public String toString() {
        return "Lot{" +
                "reference=" + reference +
                ", nom=" + nom +
                ", prix=" + prix +
                ", article=" + article +
                ", quantity=" + quantity +
                ", type='" + type + '\'' +
                '}';
    }

    public Article getArticle() {
        return article;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }
}
