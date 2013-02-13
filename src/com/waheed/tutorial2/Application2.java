/**
 * 
 */
package com.waheed.tutorial2;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * Logback provides a feature using which you can see the internal status of the logback framework,
 * It helps, if something went wrong inside the logback framework.
 * 
 * Note : before running this App, remove the logback.xml file from the classpath 
 * i,e remove from the ${Slf4jTutorial}/src folder.
 * 
 * @author abdul
 *
 */
public class Application2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// print internal state
		//Logback's internal status information can be very useful in diagnosing logback-related problems. 

		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		StatusPrinter.print(lc);

		/*Output:
		 * 
		 * 20:29:00,706 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Could NOT find resource [logback.groovy]
		 * 20:29:00,707 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Could NOT find resource [logback-test.xml]
		 * 20:29:00,707 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Could NOT find resource [logback.xml]
		 * 20:29:00,709 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Setting up default configuration.
		 * 
		 * It will print the internal state of the logback framework. As you can see logback tries find out few configuration file.
		 * first it check the logback.groovy then logback-test.xml and then logback.xml (Detail about file in tutorial:)
		 * If none of the file is present into the classpath then it will internally set the default configuration i,e
		 * it will only enable the console appender at the debug level. 
		 */


	}

}
