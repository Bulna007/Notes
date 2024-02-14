package com.be.exceptionmappers;

import org.springframework.boot.ExitCodeExceptionMapper;
import org.springframework.stereotype.Component;

@Component
public class AppExitCodeExceptionMapper implements ExitCodeExceptionMapper {
    @Override
    public int getExitCode(Throwable exception) {
        if (exception.getCause() instanceof IllegalAccessException) {
            return 100;
        }
        return 1;
    }
}
