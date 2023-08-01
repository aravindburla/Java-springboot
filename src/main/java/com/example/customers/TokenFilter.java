package com.example.customers;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class TokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization"); // Assuming the token is passed in the "Authorization" header.

        // Check if the token is present
        if (token == null || token.isEmpty()) {
            // Return an error response if the token is not present
            response.getWriter().write("Token not present");
            response.setContentType("text/plain");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized status code
            return;
        }

        // If the token is present, proceed with the next filter or the request handling
        filterChain.doFilter(request, response);
    }
}