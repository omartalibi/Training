package IPRO.projet;

import IPRO.projet.application.*;
import IPRO.projet.conservation.ApplicationSave;
import IPRO.projet.exception.IllegalFormatException;
import IPRO.projet.metier.SellableFraisPortProvider;
import IPRO.projet.metier.SellableReductionProvider;
import IPRO.projet.typage.*;
import org.junit.Assert;
import org.junit.Test;
import scala.App;

import java.io.File;
import java.io.IOException;

import static IPRO.projet.typage.Email.Email;
import static IPRO.projet.typage.FraisPort.*;
import static IPRO.projet.typage.Id.*;
import static IPRO.projet.typage.Password.Password;
import static IPRO.projet.typage.Quantity.*;
import static IPRO.projet.typage.Reduction.*;
import static IPRO.projet.typage.Username.Username;

public class IPRO_Project_Should {

    Double coutDeFonctionnement = 1200.0;
    Boutique boutique = new Boutique(coutDeFonctionnement);
    Client client;
    ISellable sellableArticle;
    ISellable sellableLot;

    @Test
    public void Client_creation() {
        client = boutique.createClient(Username("Omayos"), Password("maroc123"), Email("omar.talibi@gmail.com"), FirstName.FirstName("Omar"), LastName.LastName("TALIBI"));
        Assert.assertEquals("Client{id=0, username=Omayos, password=maroc123, email=omar.talibi@gmail.com, firstName=Omar, lastName=TALIBI, commandeList=[], prixTotal=0.0}", client.toString());
    }

    @Test
    public void Article_Creation() throws IllegalFormatException {
        sellableArticle = sellableArticle = new Article(Reference.Reference("REF01010"), Name.Name("Stylo"), Marque.Marque("Bic"), Prix.Prix(10.0), Prix.Prix(5.0),"article");
        Assert.assertEquals("Article{reference=REF01010, nom=Stylo, marque=Bic, prixPublic=10.0, coutObtention=5.0}", sellableArticle.toString());
    }

    @Test
    public void Lot_Creation() throws IllegalFormatException, IOException {
        sellableArticle = new Article(Reference.Reference("REF01010"), Name.Name("Stylo"), Marque.Marque("Bic"), Prix.Prix(10.0), Prix.Prix(5.0),"article");
        sellableLot = new Lot(Reference.Reference("REF54534"), Name.Name("Lot stylos"), (Article) sellableArticle, Quantity(3), "lot");
        Assert.assertEquals("Lot{reference=REF54534, nom=Lot stylos, prix=30.0, article=Article{reference=REF01010, nom=Stylo, marque=Bic, prixPublic=10.0, coutObtention=5.0}, quantity=3, taux_remise=0.0}", sellableLot.toString());
    }

    @Test(expected = IllegalFormatException.class)
    public void Wrong_REFERENCE_Article_Creation() throws IllegalFormatException {
            new Article(Reference.Reference("ARA01010"), Name.Name("Stylo"), Marque.Marque("Bic"), Prix.Prix(10.0), Prix.Prix(5.0),"article");
    }

    @Test
    public void Commande_Creation() throws IllegalFormatException, IOException {

        client = boutique.createClient(Username("Omayos"), Password("maroc123"), Email("omar.talibi@gmail.com"), FirstName.FirstName("Omar"), LastName.LastName("TALIBI"));
        sellableArticle = new Article(Reference.Reference("REF01010"), Name.Name("Stylo"), Marque.Marque("Bic"), Prix.Prix(10.0), Prix.Prix(5.0),"article");
        sellableLot = new Lot(Reference.Reference("REF54534"), Name.Name("Lot stylos"), (Article) sellableArticle, Quantity(3),"lot");

        Commande commande = client.createCommande(sellableArticle);

        Assert.assertEquals("Commande{id=0, date=2018-06-28, fraisPortCommande=5.0, reductionCommande=5.0, prixCommande=10.0, sellableList=[Article{reference=REF01010, nom=Stylo, marque=Bic, prixPublic=10.0, coutObtention=5.0}]}", commande.toString());

    }


    @Test
    public void Stock_creation() throws IllegalFormatException, IOException {
        sellableArticle = new Article(Reference.Reference("REF01010"), Name.Name("Stylo"), Marque.Marque("Bic"), Prix.Prix(10.0), Prix.Prix(5.0),"article");
        sellableLot = new Lot(Reference.Reference("REF54534"), Name.Name("Lot stylos"), (Article) sellableArticle, Quantity(3),"lot");


        Stock stock = new Stock(Id(1));
        stock.addSellable(sellableArticle, 3);
        stock.decreaseSellable(sellableArticle);


        Assert.assertEquals("Stock{id=1, stockQteList=[StockQte{quantity=2, isellable=Article{reference=REF01010, nom=Stylo, marque=Bic, prixPublic=10.0, coutObtention=5.0}}]}", stock.toString());

    }


    @Test
    public void Valid_SellableReductionProvider() throws IOException, IllegalFormatException {
        sellableArticle = new Article(Reference.Reference("REF01010"), Name.Name("Stylo"), Marque.Marque("Bic"), Prix.Prix(10.0), Prix.Prix(5.0),"article");
        Assert.assertEquals(Reduction(50.0).getReductionValue(), SellableReductionProvider.getReduction(sellableArticle.getReferenceObject()).getReductionValue());

    }

    @Test
    public void Invalid_SellableReductionProvider() throws IOException, IllegalFormatException {
        sellableArticle = new Article(Reference.Reference("REF04010"), Name.Name("Stylo"), Marque.Marque("Bic"), Prix.Prix(10.0), Prix.Prix(5.0),"article");
        Assert.assertEquals(Reduction(0.0).getReductionValue(), SellableReductionProvider.getReduction(sellableArticle.getReferenceObject()).getReductionValue());
    }


    @Test
    public void Valid_SellableFraisPortProvider() throws IOException, IllegalFormatException {
        sellableArticle = new Article(Reference.Reference("REF01010"), Name.Name("Stylo"), Marque.Marque("Bic"), Prix.Prix(10.0), Prix.Prix(5.0),"article");
        Assert.assertEquals(FraisPort(5.0).getFraisPortValue(), SellableFraisPortProvider.getFraisPort(sellableArticle.getReferenceObject()).getFraisPortValue());
    }

    @Test
    public void Invalid_SellableFraisPortProvider() throws IOException, IllegalFormatException {
        sellableArticle = new Article(Reference.Reference("REF055010"), Name.Name("Stylo"), Marque.Marque("Bic"), Prix.Prix(10.0), Prix.Prix(5.0), "article");
        Assert.assertEquals(FraisPort(0.0).getFraisPortValue(), SellableFraisPortProvider.getFraisPort(sellableArticle.getReferenceObject()).getFraisPortValue());
    }

    @Test
    public void application_save() throws IllegalFormatException, IOException {

        client = boutique.createClient(Username("Omayos"), Password("maroc123"), Email("omar.talibi@gmail.com"), FirstName.FirstName("Omar"), LastName.LastName("TALIBI"));
        Client client2 = boutique.createClient(Username("Omayoss"), Password("maroc12s3"), Email("omar.talsibi@gmail.com"), FirstName.FirstName("Omsar"), LastName.LastName("TAsLIBI"));

        sellableArticle = new Article(Reference.Reference("REF01010"), Name.Name("Stylo"), Marque.Marque("Bic"), Prix.Prix(10.0), Prix.Prix(5.0), "article");
        sellableLot = new Lot(Reference.Reference("REF54534"), Name.Name("Lot stylos"), (Article) sellableArticle, Quantity(3),"lot");

        client.createCommande(sellableArticle);
        client2.createCommande(sellableLot);

        ApplicationSave.save(boutique);
    }

    @Test
    public void application_retreive(){
        String hydration_source = "./src/main/resources/clients_sauvgarde.json";

        Boutique boutique = new Boutique(coutDeFonctionnement);

        ApplicationSave.hydrate(boutique, hydration_source);

        for(Client client : boutique.getAllClients()){
            System.out.println(client.toString());
        }

        }


    }
