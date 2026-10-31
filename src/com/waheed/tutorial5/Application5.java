package com.waheed.tutorial5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.waheed.LogbackConfiguration;

/**
 * Overrides Logback's default configuration with sample5.xml (ERROR level).
 *
 * <p>Run from the repository root so the sample XML path resolves correctly.</p>
 */
public class Application5 {

    private static final Logger LOG = LoggerFactory.getLogger(Application5.class);

    public static void main(String[] args) {
        LogbackConfiguration.load("sample5.xml");
        logAtEveryLevel("Overriding the logging configuration");
    }

    private static void logAtEveryLevel(String message) {
        LOG.trace(message);
        LOG.debug(message);
        LOG.info(message);
        LOG.warn(message);
        LOG.error(message);
    }
}
