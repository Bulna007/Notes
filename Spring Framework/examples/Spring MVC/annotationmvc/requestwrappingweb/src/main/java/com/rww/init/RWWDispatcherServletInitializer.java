package com.rww.init;

import com.rww.config.RWWebMvcConfig;
import com.rww.config.RootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class RWWDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{RWWebMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"*.htm"};
    }
}
