/**
 * 
 */
package com.waheed.tutorial5;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * This tutorial help you understand how you can override logback's default
 * configuration.
 * 
 * Logback relies on a configuration library called Joran which is a part of
 * logback-core. Logback's default configuration mechanism invokes
 * JoranConfigurator on the default configuration file it finds on the class
 * path.
 * 
 * I have override the Logback's default configuration i,e it will take
 * configuartion file as sample5.xml and it will look for the file form the path
 * specified.
 * 
 * 
 * @author abdul
 * 
 */
public class Application5 {

	private static final Logger LOG = LoggerFactory
			.getLogger(Application5.class);
	private static final String LOGBACK_FILE = "sample5.xml";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Application5 application = new Application5();
		application.initLogger(LOGBACK_FILE);
		application.display("Overriding configuration file");
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
	
	/* Output: 
	 * We have set root log level as ERROR that's why only ERROR message got logged.
	 *  
	 * 17:23:53.095 [main] INFO  com.waheed.tutorial5.Application5 - Initializing Logger: sample5.xml
	 * 17:23:53.106 [main] ERROR com.waheed.tutorial5.Application5 - Overriding configuration file
	 */
}
