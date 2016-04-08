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

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class MyApp2 {
	final static Logger logger = LoggerFactory.getLogger(MyApp2.class);

	/**
	 * run like:
	 * 
	 * <pre>
	 * discover-logback>mvn -Dlogback.configurationFile="src/main/java/com/toien/discover/logback/ch3/sample2.xml" exec:java -Dexec.mainClass="com.toien.discover.logback.ch3.MyApp2"
	 * 
	 * <pre>
	 * discover-logback>mvn -Dlogback.configurationFile="src/main/java/com/toien/discover/logback/ch3/variableSubstitution1.xml" exec:java -Dexec.mainClass="com.toien.discover.logback.ch3.MyApp2"
	 * 
	 * <pre>
	 * discover-logback>mvn -Dlogback.configurationFile="src/main/java/com/toien/discover/logback/ch3/variableSubstitution1.xml" -DUSER_HOME="/tmp/home/sebastien" exec:java -Dexec.mainClass="com.toien.discover.logback.ch3.MyApp2"
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// assume SLF4J is bound to logback in the current environment
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		// print logback's internal status
		StatusPrinter.print(lc);

		logger.info("Entering application.");
		Foo foo = new Foo();
		foo.doIt();
		logger.info("Exiting application.");
	}
}
