/**
 * 
 */
package com.waheed.tutorial3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This tutorial explains you best practise for parameterized logging.
 * 
 * Note : before running this App, remove the logback.xml file from the classpath 
 * i,e remove from the ${Slf4jTutorial}/src folder.
 * 
 * @author abdul
 * 
 */
public class Application3 {

	private static final Logger LOG = LoggerFactory
			.getLogger(Application3.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Application3 application = new Application3();
		application.bestPractise();
	}

	private void bestPractise() {
		
		// Read here in detal http://logback.qos.ch/manual/architecture.html
		/*AVOID THIS PRACTISE because 
		 * - it incurs the cost of constructing the message parameter i,e that is converting integer i to a String
		 * concatenating strings. This is regardless of whether the message will be logged or not.*/ 
		int i = 10;
		LOG.debug("Entry number: " + i + " is " + String.valueOf(i));

		// Another way 
		if(LOG.isDebugEnabled()) { 
			LOG.debug("Entry number: " + i + " is " + String.valueOf(i));
		}

		//Better Alternative
		/* Only after evaluating whether to log or not, and only if the decision is positive,
		 * will the logger implementation format the message and replace the '{}' pair with the variable. 
		 * In other words, this form does not incur the cost of parameter construction when the log statement is disabled. 
		 * 
		 */
		LOG.debug("Entry number is {}.", i);
		
		//two number is also there
		int j=5;
		LOG.debug("Number 1: {}, Number 2: {}",i,j);
		
		//for more then two variables
		int k=10;
		Object params[] = {i,j,k};
		LOG.debug("Number 1: {}, Number 2: {} and Number 3: {}",params);

		/*
		 * 21:10:33.610 [main] DEBUG com.waheed.tutorial3.Application3 - Entry number: 10 is 10
		 * 21:10:33.613 [main] DEBUG com.waheed.tutorial3.Application3 - Entry number: 10 is 10
		 * 21:10:33.614 [main] DEBUG com.waheed.tutorial3.Application3 - Entry number is 10.
		 * 21:10:33.614 [main] DEBUG com.waheed.tutorial3.Application3 - Number 1: 10, Number 2: 5
		 * 21:10:33.614 [main] DEBUG com.waheed.tutorial3.Application3 - Number 1: 10, Number 2: 5 and Number 3: 10
		 */
	}
}
