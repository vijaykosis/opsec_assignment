package com.opsec.api.service;

import com.opsec.api.model.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {


    User insertUserData(User person);

    Collection<User> getAllUserInformation();

    Optional<User> getUserInformationUsingId(String id);

    public void updateUserUsingId(String id, User person);

    public void deleteUserUsingId(String id);

}
