package com.toien.discover.logback.ch7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

import com.toien.discover.logback.ch6.SampleLogging;

public class FilterTest {
	/**
	 * 
	 * <pre>
	 * discover-logback>mvn -Dexec.args="src/main/java/com/toien/discover/logback/ch7/sampleFilterConfig.xml" -Dexec.mainClass="com.toien.discover.logback.ch7.FilterTest" exec:java
	 * 
	 * <pre>
	 * discover-logback>mvn -Dexec.args="src/main/java/com/toien/discover/logback/ch7/thresholdFilterConfig.xml" -Dexec.mainClass="com.toien.discover.logback.ch7.FilterTest" exec:java
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(SampleLogging.class);
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();

		try {
			JoranConfigurator configurator = new JoranConfigurator();
			lc.reset();
			configurator.setContext(lc);
			configurator.doConfigure(args[0]);
		} catch (JoranException je) {
			// StatusPrinter will handle this
		}
		StatusPrinter.printInCaseOfErrorsOrWarnings(lc);

		logger.debug("debug sample!");
		logger.debug("debug xxx");
		logger.info("info xxx");
		logger.info("info sample");
		logger.error("error sample", new RuntimeException("A normal RuntimeException."));
		logger.error("error xxx");
	}
}
