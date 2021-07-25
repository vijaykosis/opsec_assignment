package com.opsec.api.service.impl;

import com.opsec.api.dao.UserDao;
import com.opsec.api.error.handler.EntityNotFoundException;
import com.opsec.api.error.handler.UserExistsException;
import com.opsec.api.model.User;
import com.opsec.api.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * This class is responsible  for processing the user specific information.
 * and persist the retrieve the data from mongo db
 *
 * @author Vijay Kumar
 * @version 1.0
 * @since 2021-24-07
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * Return the user data from database and this method is responsible for persisting the data in mongo db.
     *
     * @param user request body with user information
     * @return
     * @throws UserExistsException
     */

    @Override
    public User insertUserData(User user) throws UserExistsException {
        validateUserInfo(user);
        User response = userDao.insertUserData(user);
        if (response == null) {
            throw new UserExistsException("user already exist", HttpStatus.INTERNAL_SERVER_ERROR.toString(), HttpStatus.INTERNAL_SERVER_ERROR.value());

        }
        return response;
    }

    /**
     * This method return all the user infromation from database.
     *
     * @return list of user infomation
     */

    @Override
    public Collection<User> getAllUserInformation() {
        Collection<User> users = userDao.getAllUserInformation();
        if (users.isEmpty()) {
            throw new EntityNotFoundException(User.class, "id's", "user list not found");
        }
        return users;
    }

    /**
     * @param id
     * @return user specific information based on id
     * @throws UserExistsException
     */

    @Override
    public Optional<User> getUserInformationUsingId(String id) throws UserExistsException {
        validateUserId(id);
        Optional<User> user = userDao.getUserInformationById(id);
        if (!user.isPresent()) {
            throw new UserExistsException("user list not found", HttpStatus.INTERNAL_SERVER_ERROR.toString(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return user;
    }

    /***
     *
     * @param id used for update the information in db
     * @param person  from request body for update case
     */

    @Override
    public void updateUserUsingId(String id, User person) {

        User user = userDao.updateUserUsingId(id, person);
        if (user == null) {
            throw new EntityNotFoundException(User.class, "id", "user list not found");
        }
    }

    /***
     *
     * @param id pass from request param to delete the specific user information
     */

    @Override
    public void deleteUserUsingId(String id) {
        userDao.deleteUserUsingId(id);
    }


    private void validateUserInfo(User user) throws UserExistsException {
        if (StringUtils.isEmpty(user.getId()) || StringUtils.isEmpty(user.getFirstName())) {
            throw new UserExistsException("id", "user id or first name is empty", HttpStatus.BAD_REQUEST.value());
        }
    }

    private void validateUserId(String userId) throws UserExistsException {
        if (StringUtils.isEmpty(userId)) {
            throw new UserExistsException("id", "user id is empty", HttpStatus.BAD_REQUEST.value());
        }
    }
}
