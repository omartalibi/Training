package integration.infra;

import java.io.InputStream;

public interface IFileDescriptor {
    String getFileName();
    InputStream getInputStream();
    String getCanonicalPath();
}
