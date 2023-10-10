package br.com.scheiner.application.config;

import java.io.IOException;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import brave.baggage.BaggageField;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component
public class CorrelationFilter implements Filter {

	public static final String CORRELATION_ID = "correlationId";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
			throws IOException, ServletException {

		if (StringUtils.isEmpty(BaggageField.getByName(CORRELATION_ID).getValue())) {
			BaggageField.getByName(CORRELATION_ID).updateValue(UUID.randomUUID().toString());
		}
		filterchain.doFilter(request, response);
	}
}
