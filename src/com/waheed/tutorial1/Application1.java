package com.waheed.tutorial1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simple tutorial which display all log level supported by Logback framework.
 * Requires slf4j-api.jar, logback-core.jar and logback-classic.jar on the
 * classpath.
 * 
 * Note : before running this App, remove the logback.xml file from the classpath 
 * i,e remove from the ${Slf4jTutorial}/src folder.
 * 
 * @author abdul
 * 
 */
public class Application1 {

	private static final Logger LOG = LoggerFactory
			.getLogger(Application1.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Application1 application = new Application1();
		application.display("Welcome to logback tutorial");
		application.division(5,0);
	}

	private void display(String message) {
		/*
		 * Logback framwork support set of possible levels (TRACE, DEBUG, INFO, WARN and ERROR)
		 * trace -> Mostly use by the developer to trace the code flow.
		 * debug -> message which you don't need it everytime or the message whose frequecny is very high logged under debug.
		 * info  -> message which you need to check everytime.
		 * warn  -> All the warning messgae come under this category.
		 * error -> All the error message logged into error level 
		 * 
		 * 
		 * Output:
		 *  20:00:17.824 [main] DEBUG com.waheed.tutorial1.Application1 - Welcome to logback tutorial
		 *  20:00:17.827 [main] INFO  com.waheed.tutorial1.Application1 - Welcome to logback tutorial
		 *  20:00:17.828 [main] WARN  com.waheed.tutorial1.Application1 - Welcome to logback tutorial
		 *  20:00:17.828 [main] ERROR com.waheed.tutorial1.Application1 - Welcome to logback tutorial
		 *  
		 *  Note : You won't able to see trace TRACE level log because bydefault the log level is set to DEBUG.
		 *  and the levels are ordered as follows: TRACE < DEBUG < INFO <  WARN < ERROR.
		 *  As TRACE priority is lower than the DEBUG level thats why logback won't logged ant TRACE LEVEL logger.
		 *  Will explain you in more details in tutorial2
		 */
		LOG.trace(message);
		LOG.debug(message);
		LOG.info(message);
		LOG.warn(message);
		LOG.error(message);
	}

	private void division(int num, int den) {
		int result = 0;
		LOG.info("Doing division task");
		if(den < 0) {
			LOG.warn("denominator canot be negative");
			den = Math.abs(den);
		}
		try {
			result = num/den;
		}catch(Exception e) {
			LOG.error("Error", e);
		}
		LOG.debug("Result: {} ",result);
		LOG.info("Division task complete");	
	}
	/*
	 * Output: 
	 * When denominator is negative  -> application.division(5,-1);
	 * 20:18:54.419 [main] INFO  com.waheed.tutorial1.Application1 - Doing division task
	 * 20:18:54.420 [main] WARN  com.waheed.tutorial1.Application1 - denominator canot be negative
	 * 20:18:54.420 [main] DEBUG com.waheed.tutorial1.Application1 - Result: 5
	 * 20:18:54.420 [main] INFO  com.waheed.tutorial1.Application1 - Division task complete
	 * 
	 * 
	 * When denominator is zero    ->  application.division(5,0);  
	 * 20:19:37.963 [main] INFO  com.waheed.tutorial1.Application1 - Doing division task
	 * 20:19:37.966 [main] ERROR com.waheed.tutorial1.Application1 - Error
	 * java.lang.ArithmeticException: / by zero
	 *         at com.waheed.tutorial1.Application1.division(Application1.java:59) [bin/:na]
	 *         at com.waheed.tutorial1.Application1.main(Application1.java:25) [bin/:na]
	 * 20:19:37.966 [main] DEBUG com.waheed.tutorial1.Application1 - Result: 0
	 * 20:19:37.967 [main] INFO  com.waheed.tutorial1.Application1 - Division task complete

	 */
}
