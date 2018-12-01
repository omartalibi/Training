package integration.infra;

import java.io.IOException;

public interface INotificationHandler {
    void HandleFile(IFileDescriptor iFileDescriptor) throws IOException;
}
