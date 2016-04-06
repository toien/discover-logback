/**
 * Logback: the reliable, generic, fast and flexible logging framework.
 * Copyright (C) 1999-2015, QOS.ch. All rights reserved.
 *
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 *
 *   or (per the licensee's choosing)
 *
 * under the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation.
 */
package com.toien.discover.logback.ch3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyApp1 {
	final static Logger logger = LoggerFactory.getLogger(MyApp1.class);

	/**
	 * <p>
	 * BasicConfigurator which will set up a minimal configuration.
	 * <p>
	 * This minimal configuration consists of a ConsoleAppender attached to the
	 * root logger.
	 * <p>
	 * The output is formatted using a PatternLayoutEncoder set to the pattern
	 * %d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n.
	 * 
	 * run like:
	 * 
	 * <pre>
	 * discover-logback>mvn -Dlogback.configurationFile="src/main/java/com/toien/discover/logback/ch3/sample1.xml" exec:java -Dexec.mainClass="com.toien.discover.logback.ch3.MyApp1"
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		logger.info("Entering application.");

		Foo foo = new Foo();
		foo.doIt();
		logger.info("Exiting application.");
	}
}
