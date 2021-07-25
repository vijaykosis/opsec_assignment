
package com.opsec.api.controller;

import com.mongodb.client.MongoClients;
import com.opsec.api.model.User;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.ImmutableMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.*;

import java.util.HashMap;
import java.util.Map;


class UserControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;

    private static final String CONNECTION_STRING = "mongodb://%s:%d";

    private MongodExecutable mongodExecutable;
    private MongoTemplate mongoTemplate;

    @AfterEach
    void clean() {
         mongodExecutable.stop();
    }

    @BeforeEach
    void setup() throws Exception {
        System.setProperty("os.arch", "Windows");
        String ip = "localhost";
        int port = 27017;

        ImmutableMongodConfig mongodConfig = MongodConfig
                .builder()
                .version(Version.Main.PRODUCTION)
                .net(new Net(ip, port, Network.localhostIsIPv6()))
                .build();

        MongodStarter starter = MongodStarter.getDefaultInstance();
        mongodExecutable = starter.prepare(mongodConfig);
        mongodExecutable.start();
        mongoTemplate = new MongoTemplate(MongoClients.create(String.format(CONNECTION_STRING, ip, port)), "test");
    }

    @Test
    void test_create() {
        HttpHeaders reqHeaders = new HttpHeaders();
        ResponseEntity<User> response = null;
        User request = new User();
        request.setId("123");
        response = this.restTemplate.exchange("/user-core-service/createUser", HttpMethod.POST, new HttpEntity<User>(request, reqHeaders), User.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    void test_getAllInfo() {
        HttpHeaders reqHeaders = new HttpHeaders();
        ResponseEntity<User> response = null;
        User request = new User();
        request.setId("123");
        response = this.restTemplate.exchange("/user-core-service/getAllInfo", HttpMethod.GET, new HttpEntity<User>(request, reqHeaders), User.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    void test_readQueryUsingId() {
        final String url = "/user-core-service/{id}";
        HttpHeaders reqHeaders = new HttpHeaders();
        ResponseEntity<User> response = null;
        User request = new User();
        request.setId("123");
        Map<String, String> params = new HashMap<>();
        params.put("code", "123456");
        HttpEntity<?> httpEntity = new HttpEntity<>(reqHeaders);
        response = this.restTemplate.exchange(url, HttpMethod.GET, httpEntity,  User.class, params);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

    }


}
