package com.waheed.tutorial7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.waheed.LogbackConfiguration;

/**
 * Demonstrates daily and size-based log rotation using sample7.xml.
 *
 * <p>Run from the repository root so the sample XML path resolves correctly.</p>
 */
public class Application7 {

    private static final Logger LOG = LoggerFactory.getLogger(Application7.class);

    public static void main(String[] args) {
        LogbackConfiguration.load("sample7.xml");
        logAtEveryLevel("Testing the rolling file appender");
    }

    private static void logAtEveryLevel(String message) {
        LOG.trace(message);
        LOG.debug(message);
        LOG.info(message);
        LOG.warn(message);
        LOG.error(message);
    }
}
