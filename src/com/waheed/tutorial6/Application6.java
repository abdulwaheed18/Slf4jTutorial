package com.waheed.tutorial6;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * This tutorial will explain you how to log all your logger messages into FILE.
 * 
 * You will observe Application5 and Application6 are identical. Yes, You are
 * right. The changes are in the configuration file "sample6.xml".
 * 
 * When you run this Application, a new log file will be created having name
 * "testLog6.log" in your Application directory Structure.
 * 
 * @author abdul
 * 
 */
public class Application6 {

	private static final Logger LOG = LoggerFactory
			.getLogger(Application6.class);
	private static final String LOGBACK_FILE = "sample6.xml";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Application6 application = new Application6();
		application.initLogger(LOGBACK_FILE);
		application.display("Writting log into the file");
	}

	private void initLogger(String loggerFile) {
		LOG.info("Initializing Logger: " + loggerFile);
		File logbackConf = null;
		logbackConf = new File(loggerFile);
		if (!logbackConf.canRead()) {
			LOG.error("Logging configuration can not be read: " + logbackConf
					+ "possibly running under wrong user directory");
		}
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		try {
			JoranConfigurator configurator = new JoranConfigurator();
			// Call lc.reset() to clear any previous configuration,
			configurator.setContext(lc);
			lc.reset();
			configurator.doConfigure(logbackConf.getAbsolutePath());
		} catch (JoranException je) {
			je.printStackTrace();
		}
		// StatusPrinter will handle this
		StatusPrinter.printInCaseOfErrorsOrWarnings(lc);
		LOG.info("Initialized Logger: " + loggerFile);
	}

	private void display(String message) {
		LOG.trace(message);
		LOG.debug(message);
		LOG.info(message);
		LOG.warn(message);
		LOG.error(message);
	}

}
