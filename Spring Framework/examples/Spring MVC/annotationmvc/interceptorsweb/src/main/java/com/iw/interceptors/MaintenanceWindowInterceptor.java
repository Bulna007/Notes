package com.iw.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Calendar;

@Component
public class MaintenanceWindowInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if(hour >= 21 && hour <= 24) {
            response.sendRedirect("site-maintenance.jsp");
            return false;
        }

        return true;
    }
}
