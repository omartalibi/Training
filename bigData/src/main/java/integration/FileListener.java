package integration;

import integration.infra.IFileDescriptor;
import integration.infra.IListener;
import integration.infra.INotificationHandler;
import integration.infra.IProvider;
import org.apache.commons.lang.NullArgumentException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileListener implements IListener {
    private IProvider iProvider;
    private INotificationHandler iNotificationHandler;
    private List<String> files;


    public FileListener(IProvider iProvider, INotificationHandler iNotificationHandler){
        if(iProvider == null)
            throw new NullArgumentException("The provider cannot be set to null.");

        if(iNotificationHandler == null)
            throw new NullArgumentException("The consumer cannot be set to null.");


        this.iProvider = iProvider;
        this.iNotificationHandler = iNotificationHandler;
        this.files = new ArrayList<>();

    }

    @Override
    public void Listen(int millis) {
            Thread thread = new Thread(() -> {
                while(true){
                    try {
                        checkForNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(millis);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.start();
    }

    public void checkForNewFile() throws IOException {
        for(IFileDescriptor iFileDescriptor : iProvider.ListFilesRecusively()){
            if(!files.contains(iFileDescriptor.getFileName())) {
                WatcherLogger.info("[NEW FILE] : " + iFileDescriptor.getFileName());
                files.add(iFileDescriptor.getFileName());
                iNotificationHandler.HandleFile(iFileDescriptor);
            }
        }
    }
}
