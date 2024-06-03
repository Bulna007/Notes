package com.tg.run;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class Runner {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        Connector connector = tomcat.getConnector();
        connector.setPort(8080);

        String contextPath = "/travelGo";
        String docBase = new File("travelgo/src/main/webapp").getAbsolutePath();

        StandardContext standardContext = (StandardContext) tomcat.addWebapp(contextPath, docBase);
        WebResourceRoot dir = new StandardRoot(standardContext);
        dir.addPreResources(new DirResourceSet(dir, "/WEB-INF/classes/", new File("travelgo/target/classes").getAbsolutePath(), "/"));
        standardContext.setResources(dir);

        tomcat.start();
        tomcat.getService().addConnector(connector);

        tomcat.getServer().await();
    }
}
