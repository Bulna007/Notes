package com.nbf;

import com.nbf.beans.Chip;
import com.nbf.beans.Robot;
import com.nbf.config.PChipConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NBFBootApplication {
    @Bean
    public Robot robot(Chip chip, @Value("${id}") int id) {
        Robot robot = new Robot();
        robot.setId(id);
        robot.setChip(chip);

        return robot;
    }

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder();
        SpringApplication springApplication = builder.parent(PChipConfig.class).child(NBFBootApplication.class).build();
        ApplicationContext applicationContext = springApplication.run(args);

        Robot robot = applicationContext.getBean(Robot.class);
        System.out.println(robot);

        ApplicationContext parentContext = applicationContext.getParent();
        Chip chip = parentContext.getBean(Chip.class);
        System.out.println(chip);
    }
}
