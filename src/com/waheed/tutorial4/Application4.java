/**
 * 
 */
package com.waheed.tutorial4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Tutorial to read configuration file from the classpath
 * Added logback.xml into the classpath
 * @author abdul
 *
 */
public class Application4 {

	private static final Logger LOG = LoggerFactory
			.getLogger(Application4.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Application4 application = new Application4();
		
		//goto ${Slf4jTutorial}/src/logback.xml file and change the root LOG level and check the o/p.
		application.testLogLevel("Reading LOG level from logback.xml file");
	}
	
	
	private void testLogLevel(String message) {
		LOG.trace(message);
		LOG.debug(message);
		LOG.info(message);
		LOG.warn(message);
		LOG.error(message);
	}

}
