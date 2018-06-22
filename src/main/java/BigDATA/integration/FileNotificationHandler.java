package BigDATA.integration;

//import jdk.internal.jline.internal.Log;
import org.apache.commons.lang.NullArgumentException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FileNotificationHandler implements INotificationHandler{
    IConsumer iconsumer;
    IProvider iprovider;
    String directory;

    public FileNotificationHandler(IProvider iprovider, IConsumer iconsumer, String directory){
        if(iprovider == null)
            throw new NullArgumentException("The provider cannot be set to null.");

        if(iconsumer == null)
            throw new NullArgumentException("The consumer cannot be set to null.");

        if(!new File(directory).canExecute() ){
            try {
                throw new IOException("The given path :" + directory + " is incorrect." );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.iprovider = iprovider;
        this.iconsumer = iconsumer;
        this.directory = directory;
    }

    @Override
    public void HandleFile(IFileDescriptor iFileDescriptorSource) throws IOException {
        IFileDescriptor iFileDescriptorDestination = new FileDescriptor(directory+"/"+iFileDescriptorSource.getFileName());
        IFileDescriptor iFileDescriptorTmp = new FileDescriptor(directory+"/"+iFileDescriptorSource.getFileName()+".tmp");

        try {
            iconsumer.createFile(iFileDescriptorTmp.getFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] block = new byte[20000000];
        int nRead;
        InputStream is = iFileDescriptorSource.getInputStream();

        try{
            while((nRead = is.read(block, 0, block.length)) != -1){

                byte[] data2send = new byte[nRead];

                //taking <20Mo data
                for(int i = 0; i< nRead; i++){
                    data2send[i] = block[i];
                }


                iconsumer.putFile(iFileDescriptorTmp.getFileName(), data2send);

            }

            if(!iconsumer.getMd5checksum(iFileDescriptorTmp.getFileName()).equals(iprovider.getMd5checksum(iFileDescriptorDestination.getFileName()))){
                WatcherLogger.info("[CHECKSUM] : KO");
                WatcherLogger.info("Resending file : "+iFileDescriptorDestination.getFileName());

                HandleFile(iFileDescriptorSource);
            }

            else {
                iconsumer.renameFile(iFileDescriptorTmp.getFileName(), iFileDescriptorDestination.getFileName());
                WatcherLogger.info("Sent file : "+iFileDescriptorDestination.getFileName());

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
