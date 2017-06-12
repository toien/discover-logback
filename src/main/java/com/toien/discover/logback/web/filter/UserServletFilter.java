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
package com.toien.discover.logback.web.filter;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.MDC;

/**
 * A simple servlet filter that puts the username found either in the Principal.
 * 
 * <p>
 * The value is removed from the MDC once the request has been fully processed.
 *
 * @author S&eacute;bastien Pennec
 */
public class UserServletFilter implements Filter {

	private final String SESSION = "session";

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		MDC.put(SESSION, req.getRequestedSessionId());
		
		try {
			chain.doFilter(request, response);
		} finally {
			MDC.remove(SESSION);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
