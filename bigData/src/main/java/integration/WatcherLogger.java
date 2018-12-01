package integration;

import java.util.logging.Logger;

public class WatcherLogger {
    private static final Logger logger = Logger.getLogger(WatcherLogger.class.getName());


    static public void info(String message){
        logger.info(message);
    }
    static public void warning(String message){
        logger.warning(message);
    }

}
