package BigDATA.integration;

import java.io.IOException;

public interface IConsumer {
    void createDirectory(String path);
    void createFile(String path) throws IOException;
    void putFile(String path, byte[] data) throws IOException;
    void renameFile(String oldPath, String newPath);
    void deleteFile(String path);
    String getMd5checksum(String path);


}