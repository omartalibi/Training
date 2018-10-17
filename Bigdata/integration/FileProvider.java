package BigDATA.integration;

import org.apache.hadoop.mapred.IFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import static BigDATA.integration.Utils.listFiles;

public class FileProvider implements IProvider {
    File sourceFile;

    public FileProvider(String path){
        sourceFile = new File(path);
    }

    @Override
    public String getName() {
        return sourceFile.getName();
    }

    @Override
    public List<IFileDescriptor> ListFilesRecusively() {
        ArrayList<File> files = new ArrayList();
        ArrayList<IFileDescriptor> fileDescriptors = new ArrayList();

        listFiles(sourceFile.getAbsolutePath(), files);

        for(File file: files){
            fileDescriptors.add(new FileDescriptor(file.getAbsolutePath()));
        }

        return fileDescriptors;
    }

    @Override
    public Boolean exists_dir(String path) {
        return null;
    }

    @Override
    public String getMd5checksum(String path) {

        try {
            FileInputStream fis;
            fis = new FileInputStream(new File(sourceFile.getAbsolutePath() + "/" + path));
            String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(fis);
            fis.close();

            WatcherLogger.info("[File CHECKSUM] : " + sourceFile.getAbsolutePath()+"/"+path + " : " + md5);

            return md5;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
