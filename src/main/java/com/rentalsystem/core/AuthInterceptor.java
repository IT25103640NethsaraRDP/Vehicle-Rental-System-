package com.rentalsystem.core;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        // Allow access to login, logout, and static resources
        if (requestURI.equals("/login") || requestURI.equals("/logout") || requestURI.startsWith("/css/") || requestURI.startsWith("/js/") || requestURI.startsWith("/images/")) {
            return true;
        }

        HttpSession session = request.getSession(false);
        // Check if user is logged in
        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }
}
