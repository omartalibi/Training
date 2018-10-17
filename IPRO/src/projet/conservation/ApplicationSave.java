package projet.conservation;

import IPRO.projet.application.*;
import projet.application.*;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import projet.typage.LastName;
import projet.typage.Name;
import projet.typage.Prix;
import projet.typage.Reference;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static projet.typage.Email.Email;
import static projet.typage.FirstName.FirstName;
import static projet.typage.Marque.Marque;
import static projet.typage.Password.Password;
import static projet.typage.Quantity.Quantity;
import static projet.typage.Username.Username;

public class ApplicationSave {

    public static boolean saved = false;

    public static void save(Boutique boutique) throws JsonMappingException {
        try {

            ObjectMapper objectMapper = new ObjectMapper();

            List<Client> clients = boutique.getAllClients();

            //clients_sauvgarde.json
            File fileClients = new File("./src/main/resources/clients_sauvgarde.json");

            Stock stock = boutique.getStock();
            File fileStock  = new File("./src/main/resources/stock_sauvgarde.json");

            if(fileClients.exists())
                fileClients.delete();
            if(fileStock.exists())
                fileStock.delete();

            if(!(fileClients.createNewFile() && fileStock.createNewFile()))
                throw new IOException();

            System.out.println("sauvgarde files are created : " + fileClients.getName() + " and " + fileStock.getName());

            objectMapper.writeValue(fileClients,clients);
            objectMapper.writeValue(fileStock, stock);



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void hydrate(Boutique boutique, String source){
        try {
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(source));

            for (Object element : jsonArray){
                JSONObject client = (JSONObject) element;

                String username = client.get("username").toString().split(":")[1].replace("\"", "").replace("}","");
                String password = client.get("password").toString().split(":")[1].replace("\"", "").replace("}","");
                String email = client.get("email").toString().split(":")[1].replace("\"", "").replace("}","");
                String firstName = client.get("firstName").toString().split(":")[1].replace("\"", "").replace("}","");
                String lastName = client.get("lastName").toString().split(":")[1].replace("\"", "").replace("}","");
                String prixTotal = client.get("prixTotal").toString().split(":")[1].replace("\"", "").replace("}","");
                String idObject = client.get("idObject").toString().split(":")[1].replace("\"", "").replace("}","");


                Client clientx = boutique.createClient(Username(username), Password(password), Email(email), FirstName(firstName), LastName.LastName(lastName));

                JSONArray commandes = (JSONArray) client.get("commandes");
                for(Object element2 : commandes){
                    JSONObject commande = (JSONObject) element2;

                    JSONArray sellables = (JSONArray) commande.get("sellableList");
                    for(Object element3 :sellables){
                        JSONObject sellable = (JSONObject) element3;

                        String type =  sellable.get("type").toString();
                        String reference = sellable.get("referenceObject").toString().split(":")[1].replace("\"", "").replace("}", "");
                        String prix = sellable.get("prixObject").toString().split(":")[1].replace("\"", "").replace("}", "");
                        String name = sellable.get("nameObject").toString().split(":")[1].replace("\"", "").replace("}", "");

                        if(type.equals("article")){
                            String coutObtention1 = sellable.get("coutObtention").toString().split(":")[1].replace("\"", "").replace("}", "");
                            String marque1 = sellable.get("marque").toString().split(":")[1].replace("\"", "").replace("}", "");

                            Article article = new Article(Reference.Reference(reference), Name.Name(name), Marque(marque1), Prix.Prix(Double.valueOf(prix)), Prix.Prix(Double.valueOf(coutObtention1)), "article");

                            clientx.createCommande(article);
                        }

                        if(type.equals("lot")){

                            JSONObject article = (JSONObject) sellable.get("article");

                            String reference2 = article.get("referenceObject").toString().split(":")[1].replace("\"", "").replace("}", "");
                            String prix2 = article.get("prixObject").toString().split(":")[1].replace("\"", "").replace("}", "");
                            String name2 = article.get("nameObject").toString().split(":")[1].replace("\"", "").replace("}", "");
                            String coutObtention2 = article.get("coutObtention").toString().split(":")[1].replace("\"", "").replace("}", "");
                            String marque2 = article.get("marque").toString().split(":")[1].replace("\"", "").replace("}", "");

                            String quantity = sellable.get("quantity").toString().split(":")[1].replace("\"", "").replace("}", "");

                            Article article1 = new Article(Reference.Reference(reference2), Name.Name(name2), Marque(marque2), Prix.Prix(Double.valueOf(prix2)), Prix.Prix(Double.valueOf(coutObtention2)), "article");
                            Lot lot = new Lot(Reference.Reference(reference), Name.Name(name),article1,Quantity(Integer.parseInt(quantity)), "lot");

                            clientx.createCommande(lot);
                        }


                    }

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
