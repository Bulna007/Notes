package com.jmsb.api;

import com.jmsb.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class UserApiControllerTest {
    @LocalServerPort
    int port;
    @MockBean
    UserService userService;
    @Autowired
    TestRestTemplate testRestTemplate;

    @BeforeEach
    void init() {
        Mockito.when(userService.getUserName(1)).thenReturn("Bill");
    }

    @Test
    void userNameTest() {
        String actualUsername = testRestTemplate.getForObject("http://localhost:" + port + "/user/name/1", String.class);
        Assertions.assertEquals("Bill", actualUsername);
    }
}
