package com.opsec.api.service;

import com.opsec.api.dao.UserDao;
import com.opsec.api.error.handler.UserExistsException;
import com.opsec.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    User insertUserData(User person) throws UserExistsException;

    Collection<User> getAllUserInformation();

    Optional<User> getUserInformationUsingId(String id) throws UserExistsException;

    void updateUserUsingId(String id, User person);

    void deleteUserUsingId(String id);

}
