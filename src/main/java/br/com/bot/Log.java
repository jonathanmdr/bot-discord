package br.com.bot;

import org.apache.log4j.Logger;

public class Log {

    private static final Logger logger = Logger.getRootLogger();

    private Log() {
        throw new IllegalStateException("Utility class");
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void warning(String message) {
        logger.warn(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

}
