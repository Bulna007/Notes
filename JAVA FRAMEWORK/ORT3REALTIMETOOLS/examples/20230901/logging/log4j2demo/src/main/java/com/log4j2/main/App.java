package com.log4j2.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private final static Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("entered into main()");
    }
}
