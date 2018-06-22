package IPRO.projet.conservation;

import IPRO.projet.application.Boutique;
import IPRO.projet.application.Client;
import IPRO.projet.application.Stock;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ApplicationSave {

    public void save(Boutique boutique) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();

            List<Client> clients = boutique.getAllClients();
            File fileClients = new File("/home/omar/Training/src/main/java/IPRO/projet/sauvgarde/clients_sauvgarde.json");

            Stock stock = boutique.getStock();
            File fileStock  = new File("/home/omar/Training/src/main/java/IPRO/projet/sauvgarde/stock_sauvgarde.json");

            if(!(fileClients.createNewFile() && fileStock.createNewFile()))
                throw new IOException();

            System.out.println("sauvgarde files are created : " + fileClients.getName() + " and " + fileStock.getName());

            objectMapper.writeValue(fileClients,clients);
            objectMapper.writeValue(fileStock, stock);



        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
