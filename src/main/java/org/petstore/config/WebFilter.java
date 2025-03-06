package org.petstore.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@Configuration
public class WebFilter implements Filter {

    private String expectedApiKey;
    private static final Logger logger = LoggerFactory.getLogger(WebFilter.class);

    public WebFilter(@Value("${api.key}") String expectedApiKey){
        this.expectedApiKey = expectedApiKey;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String apiKey = httpRequest.getHeader("x-api-key");
        String requestURI = httpRequest.getRequestURI();

        String[] filteredPaths = {"/pets", "/petstore/store"};

        boolean shouldFilter = false;
        for (String path : filteredPaths) {
            if (requestURI.startsWith(path)) {
                shouldFilter = true;
                break;
            }
        }

        logger.info("Received API Key: {}", apiKey);

        if (shouldFilter && (apiKey == null || !apiKey.equals(expectedApiKey))) {
            logger.error("Invalid API Key: {}", apiKey);
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid API Key");
        }

        chain.doFilter(request, response);
    }
}
