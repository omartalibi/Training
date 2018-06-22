package IPRO.projet;

import IPRO.projet.application.*;
import IPRO.projet.exception.IllegalFormatException;
import IPRO.projet.typage.*;
import org.junit.Assert;
import org.junit.Test;

import static IPRO.projet.typage.Email.Email;
import static IPRO.projet.typage.Password.Password;
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
        sellableArticle = sellableArticle = new Article(Reference.Reference("REF01010"), Name.Name("Stylo"), Marque.Marque("Bic"), Prix.Prix(10.0), Prix.Prix(5.0));
        Assert.assertEquals("Article{reference=REF01010, nom=Stylo, marque=Bic, prixPublic=10.0, coutObtention=5.0}", sellableArticle.toString());
    }

    @Test
    public void Lot_Creation() throws IllegalFormatException {
        sellableArticle = sellableArticle = new Article(Reference.Reference("REF01010"), Name.Name("Stylo"), Marque.Marque("Bic"), Prix.Prix(10.0), Prix.Prix(5.0));
        sellableLot = new Lot(Reference.Reference("REF54534"), Name.Name("Lot stylos"), (Article) sellableArticle, Quantity.Quantity(3));
        Assert.assertEquals("Lot{reference=REF54534, nom=Lot stylos, prix=30.0, article=Article{reference=REF01010, nom=Stylo, marque=Bic, prixPublic=10.0, coutObtention=5.0}, quantity=3, taux_remise=0.0}", sellableLot.toString());
    }

    @Test(expected = IllegalFormatException.class)
    public void Wrong_REFERENCE_Article_Creation() throws IllegalFormatException {
            new Article(Reference.Reference("ARA01010"), Name.Name("Stylo"), Marque.Marque("Bic"), Prix.Prix(10.0), Prix.Prix(5.0));
    }


}
