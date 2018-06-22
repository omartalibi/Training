package IPRO.projet.application;

import IPRO.projet.typage.*;

import static IPRO.projet.metier.SellableReductionProvider.*;
import static IPRO.projet.typage.Prix.*;
import static IPRO.projet.typage.Reduction.Reduction;

public class Lot implements ISellable{
    Reference reference;
    Name nom;
    Prix prix;

    public Lot(Reference reference, Name nom, Article article, Quantity quantity){
        this.reference = reference;
        this.nom = nom;
        this.article = article;
        this.quantity = quantity;

        this.taux_remise = getTaux_remise();
        this.prix = calculatePrix();
    }

    Article article;
    Quantity quantity;

    Reduction taux_remise;

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

    private Reduction getTaux_remise(){
        if(hasReduction(reference))
            return getReduction(reference);

        return Reduction(0.0);
    }

    /** Reduction sur l'article puis taux de remise sur le lot*/
    private Prix calculatePrix(){
        Prix articlePrixObject = article.getPrixObject();
        Double prix_lot = articlePrixObject.getPrixValue() * quantity.getQuantityValue();

        return Prix(prix_lot - (prix_lot * getTaux_remise().getReductionValue()) / 100);

    }

    @Override
    public String toString() {
        return "Lot{" +
                "reference=" + reference +
                ", nom=" + nom +
                ", prix=" + prix +
                ", article=" + article +
                ", quantity=" + quantity +
                ", taux_remise=" + taux_remise +
                '}';
    }
}
