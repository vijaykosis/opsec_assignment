package com.opsec.api.service.impl;

import com.opsec.api.client.UserCoreClient;
import com.opsec.api.error.ErrorCode;
import com.opsec.api.error.UserNotFoundException;
import com.opsec.api.model.User;
import com.opsec.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/*
UserServiceImpl class is responsible for handling for user profile specific information
based on the request user profile created/updated and deleted

 */

@Service
public class UserServiceImpl implements UserService {
    private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    UserCoreClient coreClient;


    @Override
    public User insertUserData(User user) {
        logger.info(" request received at insertUserData method {}", user);
        User response = coreClient.insertUserData(user);
        logger.info(" response from UserServiceImpl class {}", response);

        if (response == null) {
            throw new UserNotFoundException(ErrorCode.USER_NOT_FOUND);
        }
        return response;
    }


    /**
     * fetch all the user information from mongo db
     *
     * @return Collection<User>
     */
    @Override
    public Collection<User> getAllUserInformation() {
        logger.info(" request received at getAllUserInformation method..");
        List<User> userList = coreClient.getAllUserInformation();
        logger.info(" response from getAllUserInformation method {}", userList);
        if (userList.isEmpty()) {
            throw new UserNotFoundException(ErrorCode.USER_NOT_FOUND);
        }
        return userList;
    }

    /**
     * get user information based on user id
     *
     * @param id
     * @return Optional<User>
     */

    @Override
    public Optional<User> getUserInformationUsingId(String id) {
        logger.info(" request received at getUserInformationUsingId method {}", id);
        Optional<User> optionalUser = coreClient.getUserInformationUsingId(id);
        logger.info(" response from getUserInformationUsingId method {}", optionalUser);

        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException(ErrorCode.USER_NOT_FOUND);
        }
        return optionalUser;
    }

    /**
     * This method update the user information based on id and user data provide in request payload
     * This method doesn't return anything
     *
     * @param id
     * @param user
     */

    @Override
    public void updateUserUsingId(String id, User user) {
        logger.info(" request received at updateUserUsingId method {},user payload{}", id, user);
        coreClient.updateUserUsingId(id, user);
    }

    /**
     * This method delete  the user information based on id
     * This method doesn't return anything
     *
     * @param id
     */

    @Override
    public void deleteUserUsingId(String id) {
        logger.info(" request received at deleteUserUsingId method..");
        coreClient.deleteUserUsingId(id);
    }
}
