package com.ewyboy.neotech;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModLogger {

    private static final Logger logger = LogManager.getLogger(NeoTech.MOD_ID);

    public static void info(String message, Object... params) {
        logger.info(String.format(message, params));
    }

    public static void debug(String message, Object... params) {
        logger.debug(String.format(message, params));
    }

    public static void error(String message, Object... params) {
        logger.error(String.format(message, params));
    }

    public static void warning(String message, Object... params) {
        logger.warn(String.format(message, params));
    }

}
