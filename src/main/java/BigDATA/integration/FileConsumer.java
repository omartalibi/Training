package BigDATA.integration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileConsumer implements IConsumer {

    private File file;

    public FileConsumer(String path) {
        file = new File(path);
    }

    @Override
    public void createDirectory(String dirName) {
        WatcherLogger.info("[DIRECTORY CREATION] : " + file.getAbsolutePath() + "/" + dirName);

        new File(file.getAbsolutePath() + "/" + dirName).mkdir();
    }

    @Override
    public void createFile(String path) {
        WatcherLogger.info("[FILE CREATION] : " + file.getAbsolutePath() + "/" + path);

        try {
            new File(file.getAbsolutePath() + "/" + path).createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void putFile(String path, byte[] data) throws IOException {
        WatcherLogger.info("[DATA PUT] : " + file.getAbsolutePath() + "/" + path);

        Files.write(Paths.get(file.getAbsolutePath() + "/" + path), data, StandardOpenOption.APPEND);
    }

    @Override
    public void deleteFile(String path) {
        WatcherLogger.info("[FILE DELETION] : " + file.getAbsolutePath() + "/" + path);

        new File(file.getAbsolutePath() + "/" + path).delete();
    }


    @Override
    public void renameFile(String oldPath, String newPath) {
        File fileDest = new File(file.getAbsolutePath() + "/" + newPath);

        if (fileDest.exists())
            deleteFile(newPath);
        else
            createFile(newPath);

        boolean res = new File(file.getAbsolutePath() + "/" + oldPath).renameTo(fileDest);

        if (res == false) {
            WatcherLogger.warning("failed to renameFile " + oldPath + " to " + newPath);
            WatcherLogger.info("Retrying");
            renameFile(oldPath, newPath);
        }

        WatcherLogger.info("[File RENAME] : " + oldPath + " renamed to " + newPath);


    }


    @Override
    public String getMd5checksum(String path) {
        try {
            FileInputStream fis;
            fis = new FileInputStream(new File(file.getAbsolutePath() + "/" + path));
            String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(fis);
            fis.close();

            WatcherLogger.info("[File CHECKSUM] : " + file.getAbsolutePath()+"/"+path + " : " + md5);

            return md5;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
