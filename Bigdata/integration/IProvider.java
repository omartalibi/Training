package BigDATA.integration;

import java.util.List;

public interface IProvider {
    String getName();
    List<IFileDescriptor> ListFilesRecusively();
    Boolean exists_dir(String path);
    String getMd5checksum(String path);

}
