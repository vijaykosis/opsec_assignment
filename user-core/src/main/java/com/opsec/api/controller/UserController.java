package com.opsec.api.controller;

import com.opsec.api.model.User;
import com.opsec.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/user-core-service")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/createUser")
    public User create(@RequestBody User user) {
        return userService.insertUserData(user);
    }

    @GetMapping("/getAllInfo")
    public Collection<User> read() {
        return userService.getAllUserInformation();
    }

    @GetMapping(path = "{id}")
    public Optional<User> readQueryUsingId(@PathVariable("id") String id) {
        return userService.getUserInformationUsingId(id);
    }

    @PutMapping(path = "/update/{id}")
    public void update(@PathVariable String id, @RequestBody User user ) {
        userService.updateUserUsingId(id, user);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable("id") String id){
        userService.deleteUserUsingId(id);
    }
}
