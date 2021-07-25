package com.opsec.api.controller;

import com.opsec.api.error.handler.UserExistsException;
import com.opsec.api.model.User;
import com.opsec.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


/**
 * This class is responsible  for managing the user specific information.
 *
 * @author Vijay Kumar
 * @version 1.0
 * @since 2021-24-07
 */

@RestController
@RequestMapping("/user-core-service")
@Api(value = "user-core", description = "Operations pertaining to user ")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "crate a user ", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) throws UserExistsException {
        return userService.insertUserData(user);
    }

    @ApiOperation(value = "get all user information")
    @GetMapping("/getAllInfo")
    public Collection<User> getAllInfo() {
        return userService.getAllUserInformation();
    }

    @ApiOperation(value = "Search a user with an ID", response = User.class)
    @GetMapping(path = "{id}")
    public Optional<User> readQueryUsingId(@PathVariable("id") String id) throws UserExistsException {
        return userService.getUserInformationUsingId(id);
    }

    @ApiOperation(value = "Update a user with an ID")
    @PutMapping(path = "/update/{id}")
    public void update(@PathVariable String id, @RequestBody User user) {
        userService.updateUserUsingId(id, user);
    }

    @ApiOperation(value = "Delete a user  with an ID")
    @DeleteMapping(path = "/delete/{id}")
    public void deleteByUserID(@PathVariable("id") String id) {
        userService.deleteUserUsingId(id);
    }
}
