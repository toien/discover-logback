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
package com.toien.discover.logback.ch4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * This application generates log messages in numbers specified by the user.
 * */
public class EMail {
	/**
	 * 
	 * <pre>
	 * discover-logback>mvn -Dexec.args="src/main/java/com/toien/discover/logback/ch4/customBufferSize.xml 100" -Dexec.mainClass="com.toien.discover.logback.ch4.EMail" exec:java
	 * 
	 * @param args
	 * @throws Exception
	 */
	static public void main(String[] args) throws Exception {
		if (args.length != 2) {
			usage("Wrong number of arguments.");
		}

		String configFile = args[0];
		int runLength = Integer.parseInt(args[1]);

		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		JoranConfigurator configurator = new JoranConfigurator();
		lc.reset();
		configurator.setContext(lc);
		configurator.doConfigure(configFile);

		Logger logger = LoggerFactory.getLogger(EMail.class);

		for (int i = 1; i <= runLength; i++) {
			if ((i % 10) < 9) {
				logger.debug("This is a debug message. Message number: " + i);
			} else {
				logger.warn("This is a warning message. Message number: " + i);
			}
		}

		logger.error("At last an error.", new Exception("Just testing"));

//		StatusPrinter.printInCaseOfErrorsOrWarnings(lc);
	}

	static void usage(String msg) {
		System.err.println(msg);
		System.err.println("Usage: java " + EMail.class.getName() + " runLength configFile\n"
				+ "   runLength (integer) the number of logs to generate\n"
				+ "   configFile a logback configuration file in XML format."
				+ " XML files must have a '.xml' extension.");
		System.exit(1);
	}
}
