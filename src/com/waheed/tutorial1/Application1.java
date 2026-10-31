package com.waheed.tutorial1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates SLF4J levels and exception logging.
 *
 * <p>Without logback.xml on the classpath, Logback defaults to DEBUG, so TRACE
 * is suppressed. A configured root level can change the output.</p>
 */
public class Application1 {

    private static final Logger LOG = LoggerFactory.getLogger(Application1.class);

    public static void main(String[] args) {
        displayLevels("Welcome to the Logback tutorial");
        divide(5, 0);
        divide(5, -1);
    }

    private static void displayLevels(String message) {
        LOG.trace(message);
        LOG.debug(message);
        LOG.info(message);
        LOG.warn(message);
        LOG.error(message);
    }

    private static void divide(int numerator, int denominator) {
        LOG.info("Dividing {} by {}", numerator, denominator);
        if (denominator < 0) {
            LOG.warn("Denominator is negative; result will be negative");
        }
        try {
            int result = numerator / denominator;
            LOG.debug("Result: {}", result);
        } catch (ArithmeticException exception) {
            // Passing the exception as the last argument retains its stack trace.
            LOG.error("Cannot divide {} by {}", numerator, denominator, exception);
        }
    }
}
