package com.waheed.tutorial9;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This tutorial explain you how to send each threads logs to diferent file.
 * check sample9_thread.xml file.
 * 
 * @author mfyuce
 *
 */
public class Application9 {
	private static final String LOGBACK_FILE = "sample9.xml";

	// Main class logger
	private static final Logger LOG = LoggerFactory
			.getLogger(Application9.class);


	private void initLogger(String loggerFile) {
		LOG.debug("Initializing Logger: " + loggerFile);
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
		LOG.debug("Initialized Logger: " + loggerFile);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Application9 application = new Application9();
		application.initLogger(LOGBACK_FILE);
		LOG.debug("Testing Multi thread / multi file logging");

		ExecutorService executor = Executors.newFixedThreadPool(5);

		int count = 1;
		while(count<=10){
			Head head = new Head();
			head.setName("head-" + count);
			executor.execute(head);
			count++;
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		LOG.debug("Finished all threads");
	}
}
