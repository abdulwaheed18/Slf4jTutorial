package com.waheed.tutorial6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.waheed.LogbackConfiguration;

/**
 * Writes log events to both the console and a file using sample6.xml.
 *
 * <p>Run from the repository root so the sample XML path resolves correctly.</p>
 */
public class Application6 {

    private static final Logger LOG = LoggerFactory.getLogger(Application6.class);

    public static void main(String[] args) {
        LogbackConfiguration.load("sample6.xml");
        logAtEveryLevel("Writing logs to a file");
    }

    private static void logAtEveryLevel(String message) {
        LOG.trace(message);
        LOG.debug(message);
        LOG.info(message);
        LOG.warn(message);
        LOG.error(message);
    }
}
