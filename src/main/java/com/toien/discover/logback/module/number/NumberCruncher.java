package com.toien.discover.logback.module.number;

import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberCruncher {
	
	private static Logger logger = LoggerFactory.getLogger(NumberCruncher.class);
	
	public int[] factor(int number) {
		
		logger.info("Beginning to factor.");

		if (number <= 0) {
			throw new IllegalArgumentException(number + " is not a positive integer.");
		} else if (number == 1) {
			return new int[] { 1 };
		}

		Vector<Integer> factors = new Vector<Integer>();
		int n = number;

		for (int i = 2; (i <= n) && ((i * i) <= number); i++) {
			// It is bad practice to place log requests within tight loops.
			// It is done here to show interleaved log output from
			// different requests.
			logger.debug("Trying " + i + " as a factor.");

			if ((n % i) == 0) {
				logger.info("Found factor " + i);
				factors.addElement(new Integer(i));

				do {
					n /= i;
				} while ((n % i) == 0);
			}

			// Placing artificial delays in tight loops will also lead to
			// sub-optimal results. :-)
			delay(100);
		}

		if (n != 1) {
			logger.info("Found factor " + n);
			factors.addElement(new Integer(n));
		}

		int len = factors.size();

		int[] result = new int[len];

		for (int i = 0; i < len; i++) {
			result[i] = ((Integer) factors.elementAt(i)).intValue();
		}

		return result;
	}
	
	public static void delay(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}
}
