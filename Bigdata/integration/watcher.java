package BigDATA.integration;

import java.io.File;
import java.io.IOException;

public class watcher {
    public static void main(String[] args) throws IOException {

        FileConsumer fileConsumer = new FileConsumer("/home/omar/oumaima/");
        FileProvider fileProvider = new FileProvider("/home/omar/provider");

        FileNotificationHandler fileNotificationHandler = new FileNotificationHandler(fileProvider, fileConsumer, "/home/omar/oumaima");
        FileListener fileListener = new FileListener(fileProvider, fileNotificationHandler);

        fileListener.Listen(100);

    }
}
