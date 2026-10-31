package com.waheed.tutorial8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.waheed.LogbackConfiguration;

/**
 * Demonstrates an optional SMTP appender using sample8.xml.
 *
 * <p>Run from the repository root so the sample XML path resolves correctly.</p>
 */
public class Application8 {

    private static final Logger LOG = LoggerFactory.getLogger(Application8.class);

    public static void main(String[] args) {
        LogbackConfiguration.load("sample8.xml");
        logAtEveryLevel("Testing the optional SMTP appender");
    }

    private static void logAtEveryLevel(String message) {
        LOG.trace(message);
        LOG.debug(message);
        LOG.info(message);
        LOG.warn(message);
        LOG.error(message);
    }
}
