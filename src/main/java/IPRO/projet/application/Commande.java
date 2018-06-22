package IPRO.projet.application;

import IPRO.projet.typage.*;

import java.time.LocalDate;
import java.time.ZoneId;
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
    private List<ISellable> sellableList;

    public Commande(ISellable...sellables) {
        id = new Id(nextIdentifer++);

        this.date = new java.util.Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        this.reductionCommande = calculReductionCommande();
        this.fraisPortCommande = calculFraisPortCommande();
        this.prixCommande = calculPrixCommande();

        this.sellableList = Arrays.asList(sellables);
    }


    /** On part du principe que le taux est fixe pour tous les sellables avec reduction */
    private Reduction calculReductionCommande(){
            Double result = 0.0;
            Double montant_reduction;
            Reference iSellableReference;
            Prix iSellablePrix;

            for(ISellable iSellable : sellableList){

                iSellableReference = iSellable.getReferenceObject();
                iSellablePrix = iSellable.getPrixObject();

                if(hasReduction(iSellableReference)) {
                    montant_reduction = (iSellablePrix.getPrixValue() * getReduction(iSellableReference).getReductionValue()) / 100;
                    result = result + montant_reduction;
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

}
