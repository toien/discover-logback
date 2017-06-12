package com.toien.discover.logback.ch4;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.boolex.EvaluationException;
import ch.qos.logback.core.boolex.EventEvaluator;
import ch.qos.logback.core.spi.ContextAwareBase;

public class CounterBasedEvaluator extends ContextAwareBase implements
		EventEvaluator<ILoggingEvent> {
	
	private static int LIMIT = 10;
	private volatile int counter = 0;
	private String name;

	private boolean started;

	public boolean evaluate(ILoggingEvent event) throws NullPointerException, EvaluationException {
		if (event.getLevel().levelInt == Level.ERROR_INT) {
			counter++;
		}

		if (counter == LIMIT) {
			counter = 0;
			return true;
		} else {
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void start() {
		started = true;
	}

	@Override
	public void stop() {
		started = false;
	}

	@Override
	public boolean isStarted() {
		return started;
	}

}