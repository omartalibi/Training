package BigDATA.integration;

import java.io.File;
import java.util.ArrayList;

public class Utils {

    public static void listFiles(String directoryName, ArrayList<File> files) {
        File directory = new File(directoryName);

        // get all the files from a directory

        File[] fList = directory.listFiles();

        for (File file : fList) {
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                listFiles(file.getAbsolutePath(), files);
            }
        }
    }
}
