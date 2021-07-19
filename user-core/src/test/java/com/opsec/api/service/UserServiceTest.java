package com.opsec.api.service;

import com.opsec.api.dao.UserDao;
import com.opsec.api.dao.UserRepository;
import com.opsec.api.model.User;
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
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Mock
    UserDao userDao;


    @Test
    void test_insertUserData() {
        List<User> users = new ArrayList<>();
        User user = getUserInfo();
        users.add(user);
        Mockito.when(userDao.insertUserData(user)).thenReturn(user);
        Assertions.assertNotNull(userService.insertUserData(user));
    }

    @Test
    void getAllUserInformation() {
        List<User> users = new ArrayList<>();
        User user = getUserInfo();
        users.add(user);
        Mockito.when(userDao.getAllUserInformation()).thenReturn(users);
        Assertions.assertNotNull(userService.getAllUserInformation());

    }

    @Test
    void getUserInformationUsingId() {
        User user = getUserInfo();
        Optional<User> userOptional = Optional.of(user);
        Mockito.when(userDao.getUserInformationById(Mockito.anyString())).thenReturn(userOptional);
        Assertions.assertNotNull(userService.getUserInformationUsingId(user.getId()));

    }

    private User getUserInfo() {
        User user = new User();
        user.setId("123");
        user.setFirstName("vijay");
        user.setTitle("software Engineer");
        return user;
    }
}