package IPRO.projet;

import IPRO.projet.application.*;
import IPRO.projet.conservation.ApplicationSave;
import IPRO.projet.exception.IllegalFormatException;
import IPRO.projet.typage.*;
import kata.movierental.Name;

import java.io.File;
import java.io.IOException;

import static IPRO.projet.typage.Email.Email;
import static IPRO.projet.typage.FirstName.*;
import static IPRO.projet.typage.Id.*;
import static IPRO.projet.typage.LastName.*;
import static IPRO.projet.typage.Marque.Marque;
import static IPRO.projet.typage.Name.*;
import static IPRO.projet.typage.Password.Password;
import static IPRO.projet.typage.Prix.Prix;
import static IPRO.projet.typage.Quantity.Quantity;
import static IPRO.projet.typage.Reference.Reference;
import static IPRO.projet.typage.Username.*;

public class Starter {
    public static void main(String[] args) throws IllegalFormatException, IOException {

        Double coutDeFonctionnement = 1200.0;
        Boutique boutique = new Boutique(coutDeFonctionnement);
        Stock stock = new Stock(Id(0));

        Client client1 = boutique.createClient(Username("Omayos"), Password("maroc123"), Email("omar.talibi@gmail.com"), FirstName("Omar"), LastName("TALIBI"));
        Client client2 = boutique.createClient(Username("OAhizon"), Password("ahizo123"), Email("oumaima.ahizoun@gmail.com"), FirstName("Oumaima"), LastName("AHIZOUN"));

        ISellable stylo = new Article(Reference("REF005435"), Name("Stylo"),Marque("Bic"), Prix(10.0), Prix(2.0), "article" );
        ISellable table = new Article(Reference("REF005455"), Name("Table"),Marque("marque1"), Prix(200.0), Prix(120.0), "article");
        ISellable porte = new Article(Reference("REF000887"), Name("Porte"),Marque("Ikea"), Prix(20.0), Prix(753.0), "article" );

        ISellable lot_stylo = new Lot(Reference("REF005466"), Name("Lot de stylos"), (Article) stylo,Quantity(5), "lot");
        ISellable lot_table =  new Lot(Reference("REF00124"), Name("Lot de table"), (Article) table,Quantity(3), "lot");

        stock.addSellables(stylo, table, porte, lot_stylo, lot_table);

        boutique.addStock(stock);

        /** Creation d'une commande */
        Commande commande1 = client1.createCommande(stylo, porte);
        Commande commande2 = client1.createCommande(stylo);

        for(Commande commande: client1.getCommandes()){
            System.out.println(commande.toString());
            System.out.println("Commande prix total : " + commande.getPrixFinalCommande());
        }


        System.out.println("========================");
        Commande commande3 = client2.createCommande(lot_stylo);
        for(Commande commande: client2.getCommandes()){
            System.out.println(commande.toString());
            System.out.println("Commande prix total : " + commande.getPrixFinalCommande());
        }


        /** TODO : Save of stock in json */
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                ApplicationSave.save(boutique);
            }
        });



    }
}
