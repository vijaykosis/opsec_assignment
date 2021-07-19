/*
package com.opsec.api.controller;

import com.opsec.api.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.TOO_MANY_REQUESTS;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ApplicationContext context;



    @Test
    void test_create()
    {
        HttpHeaders reqHeaders = new HttpHeaders();
        ResponseEntity<User> response = null;
        reqHeaders.set("user", "user2");
        User request=new User();
        request.setId("123");
        for (int i = 0; i < 110; i++) {
            response = this.restTemplate.exchange("/api/v1/createUser", HttpMethod.POST, new HttpEntity<User>(request, reqHeaders), User.class);
        }
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());


    }

    @Test
    void read() {
    }

    @Test
    void readQueryUsingId() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}*/
