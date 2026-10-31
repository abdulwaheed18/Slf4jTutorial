package com.waheed.tutorial2;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * Prints Logback's internal status to diagnose configuration problems.
 *
 * <p>Try running with and without logback.xml on the classpath to compare
 * the configuration messages.</p>
 */
public class Application2 {

    public static void main(String[] args) {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(context);
    }
}
