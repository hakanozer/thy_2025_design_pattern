package com.works.configs;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class FilterConfig implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();

        String token = request.getHeader("token");
        filterChain.doFilter(request, response);
        /*
        if (token != null ) {
            filterChain.doFilter(request, response);
        }else {
            response.setStatus(401);
            PrintWriter printWriter = response.getWriter();
            printWriter.println("Login Fail");
        }
         */

    }

}
