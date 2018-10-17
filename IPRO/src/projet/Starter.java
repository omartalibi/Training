package projet;

import IPRO.projet.application.*;
import projet.conservation.ApplicationSave;
import projet.exception.IllegalFormatException;
import projet.application.*;
import projet.typage.*;

import java.io.File;
import java.io.IOException;

import static projet.typage.FirstName.*;
import static projet.typage.Marque.Marque;
import static projet.typage.Password.Password;
import static projet.typage.Quantity.Quantity;
import static projet.typage.Username.*;

public class Starter {
    public static void main(String[] args) throws IllegalFormatException, IOException {

        Double coutDeFonctionnement = 1200.0;
        Boutique boutique = new Boutique(coutDeFonctionnement);
        Stock stock = new Stock(Id.Id(0));


        //A l'ouverture
        if(new File("./src/main/resources/clients_sauvgarde.json").exists())
            ApplicationSave.hydrate(boutique, "./src/main/resources/clients_sauvgarde.json");

        //A la fermeture
        /** TODO : Save of stock in json */
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                ApplicationSave.save(boutique);
            }
        });

        Client client1 = boutique.createClient(Username("Omayos"), Password("maroc123"), Email.Email("omar.talibi@gmail.com"), FirstName("Omar"), LastName.LastName("TALIBI"));
        Client client2 = boutique.createClient(Username("OAhizon"), Password("ahizo123"), Email.Email("oumaima.ahizoun@gmail.com"), FirstName("Oumaima"), LastName.LastName("AHIZOUN"));

        ISellable stylo = new Article(Reference.Reference("REF005435"), Name.Name("Stylo"),Marque("Bic"), Prix.Prix(10.0), Prix.Prix(2.0), "article" );
        ISellable table = new Article(Reference.Reference("REF005455"), Name.Name("Table"),Marque("marque1"), Prix.Prix(200.0), Prix.Prix(120.0), "article");
        ISellable porte = new Article(Reference.Reference("REF000887"), Name.Name("Porte"),Marque("Ikea"), Prix.Prix(20.0), Prix.Prix(753.0), "article" );

        ISellable lot_stylo = new Lot(Reference.Reference("REF005466"), Name.Name("Lot de stylos"), (Article) stylo,Quantity(5), "lot");
        ISellable lot_table =  new Lot(Reference.Reference("REF00124"), Name.Name("Lot de table"), (Article) table,Quantity(3), "lot");

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


        System.out.println("=================");

        for(Client client: boutique.getAllClients()){
            for(Commande commande: client.getCommandes()){
                System.out.println(commande.toString());
            }
        }




    }
}
