package com.jmsb.api;

import com.jmsb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserApiController {
    private final UserService userService;

    @GetMapping(value = "/name/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> userName(@PathVariable("id") int id) {
        String username = null;

        username = userService.getUserName(id);
        return ResponseEntity.ok(username);
    }
}
