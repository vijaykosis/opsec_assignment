/*
package com.opsec.api.controller;

import com.blueoptima.throttling.api.constants.RateLimitConstants;
import com.blueoptima.throttling.api.model.UserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.TOO_MANY_REQUESTS;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ThrottlingControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ApplicationContext context;


    @Test
    public void test_RateLimitUser_Developers_1() throws InterruptedException {
        HttpHeaders reqHeaders = new HttpHeaders();
        ResponseEntity<String> response = null;
        reqHeaders.set("user", "user2");
        UserRequest request=new UserRequest();
        request.setUser("user1");
        for (int i = 0; i < 110; i++) {
            response = this.restTemplate.exchange("/api/v1/developers", HttpMethod.POST, new HttpEntity<UserRequest>(request, reqHeaders), String.class);
        }
        Assertions.assertEquals(TOO_MANY_REQUESTS, response.getStatusCode());
    }
    @Test
    public void test_RateLimitUser_Developers_2() throws InterruptedException {
        HttpHeaders reqHeaders = new HttpHeaders();
        ResponseEntity<String> response = null;
        reqHeaders.set("user", "user2");
        UserRequest request=new UserRequest();
        request.setUser("user1");
        for (int i = 0; i < 600; i++) {
            response = this.restTemplate.exchange("/api/v1/developers", HttpMethod.POST, new HttpEntity<UserRequest>(request, reqHeaders), String.class);
        }
        Assertions.assertEquals(TOO_MANY_REQUESTS, response.getStatusCode());
    }
    @Test
    public void test_RateLimitUser_organizations_2() throws InterruptedException {
        HttpHeaders reqHeaders = new HttpHeaders();
        ResponseEntity<String> response = null;
        reqHeaders.set("user", "user1");
        UserRequest request=new UserRequest();
        request.setUser("user1");
        for (int i = 0; i < 300; i++) {
            response = this.restTemplate.exchange("/api/v1/organizations", HttpMethod.POST, new HttpEntity<UserRequest>(request, reqHeaders), String.class);
        }
        Assertions.assertEquals(TOO_MANY_REQUESTS, response.getStatusCode());
    }
    @Test
    public void test_RateLimitUser_organizations_1() throws InterruptedException {
        HttpHeaders reqHeaders = new HttpHeaders();
        ResponseEntity<String> response = null;
        reqHeaders.set("user", "user3");
        UserRequest request=new UserRequest();
        request.setUser("user1");
        for (int i = 0; i < 600; i++) {
            response = this.restTemplate.exchange("/api/v1/organizations", HttpMethod.POST, new HttpEntity<UserRequest>(request, reqHeaders), String.class);
        }
        Assertions.assertEquals(TOO_MANY_REQUESTS, response.getStatusCode());
    }


    private void assertHeaders(HttpHeaders headers, String key,
                               boolean nullable, boolean quotaHeaders) {
        String limit = headers.getFirst(RateLimitConstants.LIMIT + key);
        String remaining = headers.getFirst(RateLimitConstants.REMAINING + key);

        if (nullable) {

            Assertions.assertNotNull(limit);
            Assertions.assertNotNull(remaining);

        } else {

            Assertions.assertNotNull(limit);
            Assertions.assertNotNull(remaining);

        }
    }
}

*/
