package com.opsec.api.dao;

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

@ExtendWith(MockitoExtension.class)
class UserDaoTest {

    @InjectMocks
    @Spy
    UserDao userDao;

    @Mock
    UserRepository userRepository;


    @Test
    void test_insertUserData() {
        List<User> users = new ArrayList<>();
        User user = getUserInfo();
        users.add(user);
        Mockito.when(userRepository.insert(user)).thenReturn(user);
        Assertions.assertNotNull(userDao.insertUserData(user));

    }

    @Test
    void test_getAllUserInformation() {

        List<User> users = new ArrayList<>();
        User user = getUserInfo();
        users.add(user);
        Mockito.when(userRepository.findAll()).thenReturn(users);
        Assertions.assertNotNull(userDao.getAllUserInformation());
    }


    @Test
    void test_getUserInformationById() {
        User user = getUserInfo();
        Optional<User> userOptional = Optional.of(user);
        Mockito.when(userRepository.findById(Mockito.anyString())).thenReturn(userOptional);
        Assertions.assertNotNull(userDao.getUserInformationById(user.getId()));
    }

    @Test
    void test_updateUserUsingId() {
        User user = getUserInfo();
        Optional<User> userOptional = Optional.of(user);
        Mockito.when(userRepository.findById(Mockito.anyString())).thenReturn(userOptional);
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(user);
        Assertions.assertNotNull(userDao.updateUserUsingId(user.getId(), user));

    }

    @Test
    void deleteUserUsingId() {
        User user = getUserInfo();
        Mockito.doNothing().when(userRepository).deleteById(Mockito.anyString());
        userDao.deleteUserUsingId(user.getId());
    }

    private User getUserInfo() {
        User user = new User();
        user.setId("123");
        user.setFirstName("vijay");
        user.setTitle("software Engineer");
        return user;
    }
}