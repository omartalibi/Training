package IPRO.projet.application;


import IPRO.projet.exception.IllegalFormatException;
import IPRO.projet.typage.*;


public class Article implements ISellable {
    private Reference reference;
    private Name nom;
    private Marque marque;
    private Prix prixPublic;
    private Prix coutObtention;
    private String type;

    public Article(Reference reference, Name nom, Marque marque, Prix prixPublic, Prix coutObtention, String type) throws IllegalFormatException {
        this.reference = reference;
        this.nom = nom;
        this.marque = marque;
        this.prixPublic = prixPublic;
        this.coutObtention = coutObtention;
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
        return prixPublic;
    }

    @Override
    public String toString() {
        return "Article{" +
                "reference=" + reference +
                ", nom=" + nom +
                ", marque=" + marque +
                ", prixPublic=" + prixPublic +
                ", coutObtention=" + coutObtention +
                '}';
    }


    public Marque getMarque() {
        return marque;
    }

    public Prix getCoutObtention() {
        return coutObtention;
    }

    public String getType() {
        return type;
    }
}
