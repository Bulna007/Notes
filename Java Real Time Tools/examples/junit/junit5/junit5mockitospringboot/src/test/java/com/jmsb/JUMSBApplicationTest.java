package com.jmsb;

import com.jmsb.api.UserApiController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JUMSBApplicationTest {
    @Autowired
    UserApiController userApiController;


    @Test
    void contextLoads() {
        Assertions.assertThat(userApiController).isNotNull();
    }
}
