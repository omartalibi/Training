package IPRO.projet.application;

import IPRO.projet.typage.*;

import java.util.List;

 public interface IGestion {

     Client createClient(Username username, Password password, Email email, FirstName firstName, LastName lastName);
     List<Client> getAllClients();
     Client getClient(int clientID);
     Boolean affectClient(Client client);


     Double getBenefice();
     Double getChiffreDaffaire();
     Double getCoutDeFonctionnement();

     List<Commande> getAllCommandes();
     List<Commande> getCommandes(int clientID);

     Stock getStock();
}
