package IPRO.projet.application;


import IPRO.projet.typage.*;
import java.util.*;


public class Boutique implements IGestion{
    private Double chiffreDaffaire;
    private Double coutDeFonctionnement;
    private List<Client> clients = new ArrayList<>();
    private Stock stock;

    public Boutique(Double coutDeFonctionnement){
        this.chiffreDaffaire = getChiffreDaffaire();
    }

    public Boutique(Double coutDeFonctionnement, Stock stock){
        this.chiffreDaffaire = getChiffreDaffaire();
        this.stock = stock;
    }

    @Override
    public Client createClient(Username username, Password password, Email email, FirstName firstName, LastName lastName) {
        Client client = new Client(username, password, email, firstName, lastName);
        affectClient(client);
        return client;
    }

    @Override
    public List<Client> getAllClients() {
        return clients;
    }

    @Override
    public Client getClient(int clientID){
        for(Client client: getAllClients()){
            Id clientIDObject = client.getIdObject();
            if(clientIDObject.getIdValue() == clientID)
                return client;
        }

        try {
            throw new ClassNotFoundException(clientID + " is not found.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Boolean affectClient(Client client){
        return this.clients.add(client);
    }

    @Override
    public Double getBenefice() {
       return getChiffreDaffaire() - getCoutDeFonctionnement();
    }

    @Override
    public Double getChiffreDaffaire() {
        Double result = 0.0;
        for(Commande commande: getAllCommandes()){
            result = result + commande.getPrixFinalCommande().getPrixValue();
        }
        return result;
    }

    @Override
    public Double getCoutDeFonctionnement(){
        return coutDeFonctionnement;
    }


    @Override
    public List<Commande> getAllCommandes() {
        List<Commande> allCommandes = new ArrayList<>();
        for(Client client: getAllClients()){
            allCommandes.addAll(client.getCommandes());
        }
        return allCommandes;
    }

    @Override
    public List<Commande> getCommandes(int clientID) {
        return getClient(clientID).getCommandes();

    }

    @Override
    public Stock getStock() {
        return stock;
    }

    public void addStock(Stock stock){
        this.stock = stock;
    }


}
