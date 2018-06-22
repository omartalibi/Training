package BigDATA.integration;

import java.io.*;

public class FileDescriptor implements IFileDescriptor {
    private File file;

    public FileDescriptor(String path){
        file = new File(path);
    }

    @Override
    public String getFileName() {
        return file.getName();
    }

    @Override
    public InputStream getInputStream() {
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getCanonicalPath() {
        try {
            return file.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
