package com.waheed.tutorial4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reads logback.xml from the classpath. Change its root level to compare output.
 */
public class Application4 {

    private static final Logger LOG = LoggerFactory.getLogger(Application4.class);

    public static void main(String[] args) {
        String message = "Reading the level from logback.xml";
        LOG.trace(message);
        LOG.debug(message);
        LOG.info(message);
        LOG.warn(message);
        LOG.error(message);
    }
}
