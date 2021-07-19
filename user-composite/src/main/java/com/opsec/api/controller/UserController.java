package com.opsec.api.controller;

import com.opsec.api.model.User;
import com.opsec.api.service.UserService;
import com.opsec.api.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

/*
UserController class is responsible for handling all the user specific request and also works AS composite layer to call
other micro services
 */

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserService userService;


    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        logger.info("request received at createUser method {}", user);
        return userService.insertUserData(user);
    }

    @GetMapping("/getAllInfo")
    public Collection<User> getAllInfo() {
        logger.info("request received at getAllInfo method {}");
        return userService.getAllUserInformation();
    }

    @GetMapping(path = "{id}")
    public Optional<User> getUserInfoUsingId(@PathVariable("id") String id) {
        logger.info("request received at getUserInfoUsingId method {}", id);
        return userService.getUserInformationUsingId(id);
    }

    @PutMapping(path = "/update/{id}")
    public void updateUserInfoUsingId(@PathVariable String id, @RequestBody User user) {
        logger.info("request received at updateUserInfoUsingId method {}", id);
        userService.updateUserUsingId(id, user);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteUserInfoUsingId(@PathVariable("id") String id) {
        logger.info("request received at deleteUserInfoUsingId method {}", id);

        userService.deleteUserUsingId(id);
    }
}
