package com.waheed;

import java.io.File;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * Loads a sample configuration from the working directory.
 *
 * <p>Resetting the context makes the selected sample replace any configuration
 * that Logback loaded at startup.</p>
 */
public final class LogbackConfiguration {

    private LogbackConfiguration() {
        // Utility class.
    }

    /**
     * @param path path to a readable sample XML file
     * @throws IllegalArgumentException if the file is missing or unreadable
     * @throws IllegalStateException if Logback cannot parse the file
     */
    public static void load(String path) {
        File configuration = new File(path);
        if (!configuration.isFile() || !configuration.canRead()) {
            throw new IllegalArgumentException(
                    "Cannot read logging configuration: " + configuration.getAbsolutePath());
        }

        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(context);
        context.reset();
        try {
            configurator.doConfigure(configuration.getAbsolutePath());
        } catch (JoranException exception) {
            StatusPrinter.printInCaseOfErrorsOrWarnings(context);
            throw new IllegalStateException(
                    "Cannot load logging configuration: " + configuration.getAbsolutePath(),
                    exception);
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(context);
    }
}
