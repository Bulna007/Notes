package com.bt.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class HitCountInterceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Object hitCount = request.getServletContext().getAttribute("hitCount");
        long hc = 0;
        if(hitCount == null) {
            hc = 1;
        }else {
            hc = (long) hitCount;
            hc++;
        }
        request.getServletContext().setAttribute("hitCount", hc);
    }
}
