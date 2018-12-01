package IPRO.cours.bills;

import IPRO.cours.stock.Sellable;
import IPRO.cours.client.Client;

import java.util.ArrayList;
import java.util.List;

public class Bill {

    private class raw{
        int quantity;
        Sellable sellable;

        public raw(int quantity, Sellable sellable) {
            this.quantity = quantity;
            this.sellable = sellable;
        }
    }

    private List<raw> raws = new ArrayList<>();
    private Client client;
    private String date;

    public Bill(Client client){
        this.client = client;
    }

    public void add(int quantity, Sellable sellable){
        raws.add(new raw(quantity, sellable));
    }

    public String getDate(){
        return this.date;
    }
}
