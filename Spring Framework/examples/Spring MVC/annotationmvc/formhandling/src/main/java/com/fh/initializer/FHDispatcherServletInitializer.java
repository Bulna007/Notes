package com.fh.initializer;

import com.fh.config.FHRootConfig;
import com.fh.config.FHWebMvcConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class FHDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{FHRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{FHWebMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"*.htm"};
    }
}
