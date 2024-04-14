package com.ehw.controller;

import com.ehw.exception.DormantAccountException;
import com.ehw.exception.LimitExceededException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionControllerAdvice {
    @ExceptionHandler(DormantAccountException.class)
    public ModelAndView handleDormantAccountException(DormantAccountException e) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error-page");
        mav.addObject("errorMessage", "From/To Account is closed");
        return mav;
    }

    @ExceptionHandler(LimitExceededException.class)
    public ModelAndView handleLimitExceededException(LimitExceededException e) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error-page");
        mav.addObject("errorMessage", "In-Sufficient Funds");
        return mav;
    }
}
