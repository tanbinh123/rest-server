package com.mac.springboot.controller;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Order(1)
public class RequestResponseLoggingFilter implements Filter {

	private MetricService metricService;

	@Override
	public void init(FilterConfig config) throws ServletException {
		metricService = (MetricService) WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext()).getBean("metricService");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		System.out.println(
				String.format("Logging Request  %s : %s", httpRequest.getMethod(), httpRequest.getRequestURI()));
		chain.doFilter(request, response);
		String.format("Logging Response %s", httpResponse.getContentType());

		String req = httpRequest.getMethod() + " " + httpRequest.getRequestURI();

		chain.doFilter(request, response);

		int status = ((HttpServletResponse) response).getStatus();
		metricService.increaseCount(req, status);

	}

}
