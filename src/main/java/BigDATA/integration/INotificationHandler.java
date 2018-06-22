package BigDATA.integration;

import java.io.IOException;

public interface INotificationHandler {
    void HandleFile(IFileDescriptor iFileDescriptor) throws IOException;
}
