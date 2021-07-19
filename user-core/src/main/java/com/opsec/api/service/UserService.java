package com.opsec.api.service;

import com.opsec.api.dao.UserDao;
import com.opsec.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public User insertUserData(User person) {
        return userDao.insertUserData(person);
    }

    public Collection<User> getAllUserInformation() {
        return userDao.getAllUserInformation();
    }

    public Optional<User> getUserInformationUsingId(String id) {
        return userDao.getUserInformationById(id);
    }

    public void updateUserUsingId(String id, User person) {
        userDao.updateUserUsingId(id, person);
    }

    public void deleteUserUsingId(String id) {
        userDao.deleteUserUsingId(id);
    }

}
