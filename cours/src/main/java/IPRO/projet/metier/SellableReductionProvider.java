package IPRO.projet.metier;

import IPRO.projet.typage.Reduction;
import IPRO.projet.typage.Reference;

import java.io.*;

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
                    return Reduction.Reduction(Double.parseDouble(reductions[1]));
            }
        }

        return Reduction.Reduction(0.0);

    }
}
