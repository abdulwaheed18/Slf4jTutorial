package com.waheed.tutorial8;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * This tutorial explain you the use of SMTPAppender i,e 
 * you can send the log to the specified user. check sample8.xml file.
 * 
 * Note: Other than logback jars, you also need JAVAMAIL and JAVABEAN FRAMEWORK ACTIVATION jars too into your classpath.
 * 
 * 
 * @author abdul
 *
 */
public class Application8 {

	private static final Logger LOG = LoggerFactory
			.getLogger(Application8.class);
	private static final String LOGBACK_FILE = "sample8.xml";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Application8 application = new Application8();
		application.initLogger(LOGBACK_FILE);
		application.display("Testing SMTP appender");

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
