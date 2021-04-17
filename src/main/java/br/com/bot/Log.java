package br.com.bot;

import java.util.logging.Logger;

public class Log {

    private static final Logger logger = Logger.getLogger(Log.class.getName());

    private Log() {
        throw new IllegalStateException("Utility class");
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void warning(String message) {
        logger.warning(message);
    }

}
