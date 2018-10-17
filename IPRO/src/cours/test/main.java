package cours.test;

import cours.client.Client;
import cours.bills.Bill;
import cours.stock.Couleur;
import cours.stock.Lot;
import cours.stock.Ream;
import cours.stock.Stylo;

public class main {
    public static void main(String[] args) {

        Stylo styloJade = new Stylo("s1", "Stylo Jade", "Watertruc", "N/A", 50.0f, Couleur.Blue);
        Ream ream = new Ream("r1", "Ramette haute qualité", "Flouefontaine", "N/A", 9.5f, "N/A");
        Lot lotStyloOr = new Lot("l1", new Stylo("s2", "Stylo or", "N/A", "N/A", 100f, Couleur.Rouge), 2, 20f);
        Client c1 = new Client("Omar", "omar.talibi@gmail.com");

        Bill bill  = new Bill(c1);
        bill.add(10, styloJade);
        bill.add(15, ream);
        bill.add(2, lotStyloOr);


        // TODO : Formatage + Affichage
    }
}
