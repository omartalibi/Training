package BigDATA.integration;

import java.io.InputStream;

public interface IFileDescriptor {
    String getFileName();
    InputStream getInputStream();
    String getCanonicalPath();
}
