package com.opsec.api.service;

import com.opsec.api.dao.UserDao;
import com.opsec.api.dao.UserRepository;
import com.opsec.api.error.handler.UserExistsException;
import com.opsec.api.model.User;
import com.opsec.api.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    @Spy
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Mock
    UserDao userDao;


    @Test
    void test_insertUserData() throws UserExistsException {
        List<User> users = new ArrayList<>();
        User user = getUserInfo();
        users.add(user);
        Mockito.when(userDao.insertUserData(user)).thenReturn(user);
        Assertions.assertNotNull(userService.insertUserData(user));
    }

    @Test
    void test_insertUserData_1() throws UserExistsException {
        List<User> users = new ArrayList<>();
        User user = null;
        Mockito.when(userDao.insertUserData(user)).thenReturn(null);
        try {
            userService.insertUserData(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void test_getAllUserInformation() {
        List<User> users = new ArrayList<>();
        User user = getUserInfo();
        users.add(user);
        Mockito.when(userDao.getAllUserInformation()).thenReturn(users);
        Assertions.assertNotNull(userService.getAllUserInformation());

    }

    @Test
    void test_getUserInformationUsingId() throws UserExistsException {
        User user = getUserInfo();
        Optional<User> userOptional = Optional.of(user);
        Mockito.when(userDao.getUserInformationById(Mockito.anyString())).thenReturn(userOptional);
        Assertions.assertNotNull(userService.getUserInformationUsingId(user.getId()));

    }

    @Test
    void test_getUserInformationUsingId_1() {
        try {
            userService.getUserInformationUsingId("");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void test_updateUserUsingId() throws UserExistsException {
        try {
            User user = getUserInfo();
            Mockito.when(userDao.updateUserUsingId(Mockito.anyString(), Mockito.anyObject())).thenReturn(user);
            userService.updateUserUsingId("", user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void test_deleteByUserID() throws UserExistsException {
        User user = getUserInfo();
        Mockito.doNothing().when(userDao).deleteUserUsingId(Mockito.anyString());
        userService.deleteUserUsingId("123");
    }


    private User getUserInfo() {
        User user = new User();
        user.setId("123");
        user.setFirstName("vijay");
        user.setTitle("software Engineer");
        return user;
    }
}