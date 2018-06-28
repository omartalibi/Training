package IPRO.projet.metier;

import IPRO.cours.stock.Sellable;
import IPRO.projet.typage.Reduction;
import IPRO.projet.typage.Reference;
import scala.Int;

import java.io.*;
import java.util.HashMap;

import static IPRO.projet.typage.Reduction.*;

public class SellableReductionProvider {

    public static boolean hasReduction(Reference reference){
        return true;
    }

    public static Reduction getReduction(Reference reference) throws IOException {
        //Reduction en %

        File reductionFile = new File("./src/main/resources/reductions.csv");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(reductionFile));
        String line;

        while((line = bufferedReader.readLine()) != null){

            if(!line.startsWith("#")){
                String[] reductions = line.split(";");

                if(reductions[0].equals(reference.getReferenceValue()))
                    return Reduction(Double.parseDouble(reductions[1]));
            }
        }

        return Reduction(0.0);

    }
}
