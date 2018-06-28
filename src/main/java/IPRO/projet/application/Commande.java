package IPRO.projet.application;

import IPRO.cours.stock.Sellable;
import IPRO.projet.typage.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static IPRO.projet.metier.SellableFraisPortProvider.*;
import static IPRO.projet.metier.SellableReductionProvider.*;
import static IPRO.projet.typage.FraisPort.FraisPort;
import static IPRO.projet.typage.Prix.*;
import static IPRO.projet.typage.Reduction.*;

public class Commande {
    private static int nextIdentifer = 0;

    private Id id;
    private LocalDate date;
    private FraisPort fraisPortCommande;
    private Reduction reductionCommande;
    private Prix prixCommande;
    private List<ISellable> sellableList = new ArrayList<>();

    public Commande(ISellable...sellables) throws IOException {
        id = new Id(nextIdentifer++);

        this.date = new java.util.Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        this.sellableList = Arrays.asList(sellables);

        this.reductionCommande = calculReductionCommande();
        this.fraisPortCommande = calculFraisPortCommande();
        this.prixCommande = calculPrixCommande();

    }


    /** On part du principe que le taux est fixe pour tous les sellables avec reduction */
    private Reduction calculReductionCommande() throws IOException {
            Double result = 0.0;
            Double montant_reduction;

            for(ISellable iSellable : sellableList){

                if(iSellable instanceof Article){
                    Reference articleReference = iSellable.getReferenceObject();
                    Prix articlePrix = iSellable.getPrixObject();

                    if(hasReduction(articleReference)) {
                        montant_reduction = (articlePrix.getPrixValue() * getReduction(articleReference).getReductionValue()) / 100;
                        result = result + montant_reduction;
                    }
                }

                if(iSellable instanceof Lot){
                    Reference lotReference = iSellable.getReferenceObject();
                    Prix lotPrix = iSellable.getPrixObject();

                    if(hasReduction(lotReference)) {
                        montant_reduction = (lotPrix.getPrixValue() * getReduction(lotReference).getReductionValue()) / 100;
                        result = result + montant_reduction;
                    }


                    Reference articleReference = ((Lot) iSellable).getArticle().getReferenceObject();
                    Prix articlePrix = ((Lot) iSellable).getArticle().getPrixObject();
                    int quantite = ((Lot) iSellable).getQuantity().getQuantityValue();

                    if(hasReduction(articleReference)){
                        montant_reduction = (articlePrix.getPrixValue() * quantite * getReduction(articleReference).getReductionValue()) / 100;
                        result = result + montant_reduction;
                    }

                }




            }

            return Reduction(result);
    }

    /** On part du principe que les sellables peuvent provenir de pays differents => donc pas frais de port par sellable*/
    private FraisPort calculFraisPortCommande(){
        Double result = 0.0;
        Reference iSellableReference;

        for(ISellable iSellable : sellableList){
                iSellableReference = iSellable.getReferenceObject();
                result = result + getFraisPort(iSellableReference).getFraisPortValue();
        }

        return FraisPort(result);
    }

    /** Prix initial de la commande */
    private Prix calculPrixCommande(){
        Double result = 0.0;
        Prix iSellablePrix;

        for(ISellable iSellable : sellableList){
            iSellablePrix = iSellable.getPrixObject();
            result = result + iSellablePrix.getPrixValue();
        }

        return Prix(result);
    }

    public Prix getPrixFinalCommande(){
        Double result = prixCommande.getPrixValue() + fraisPortCommande.getFraisPortValue() - reductionCommande.getReductionValue();

        return Prix(result);
    }

    public Boolean addSellable(ISellable sellable){

        return sellableList.add(sellable);
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", date=" + date +
                ", fraisPortCommande=" + fraisPortCommande +
                ", reductionCommande=" + reductionCommande +
                ", prixCommande=" + prixCommande +
                ", sellableList=" + sellableList +
                '}';
    }


    public Id getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public FraisPort getFraisPortCommande() {
        return fraisPortCommande;
    }

    public Reduction getReductionCommande() {
        return reductionCommande;
    }

    public Prix getPrixCommande() {
        return prixCommande;
    }

    public List<ISellable> getSellableList() {
        return sellableList;
    }
}
