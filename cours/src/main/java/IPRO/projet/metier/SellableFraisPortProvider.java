package IPRO.projet.metier;

import IPRO.projet.typage.Reference;
import IPRO.projet.typage.FraisPort;

import java.io.*;

import static IPRO.projet.typage.FraisPort.*;

public class SellableFraisPortProvider {
    public static FraisPort getFraisPort(Reference reference)  {
        //Frais de port en montant (euros...)

        try {
            File fraisPortFile = new File("./src/main/resources/fraisport.csv");
            BufferedReader bufferedReader = null;
            String line;
            bufferedReader = new BufferedReader(new FileReader(fraisPortFile));
            while((line = bufferedReader.readLine()) != null){

                if(!line.startsWith("#")){
                    String[] reductions = line.split(";");

                    if(reductions[0].equals(reference.getReferenceValue()))
                        return FraisPort(Double.parseDouble(reductions[1]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return FraisPort(0.0);

    }

}
