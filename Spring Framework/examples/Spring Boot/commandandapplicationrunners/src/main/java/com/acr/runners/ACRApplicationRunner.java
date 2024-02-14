package com.acr.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Order(1)
public class ACRApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Set<String> optionNames = args.getOptionNames();
        optionNames.stream().forEach(optionName->{
            System.out.println(optionName + " = " + args.getOptionValues(optionName).get(0));
        });

    }
}
