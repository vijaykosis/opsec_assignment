package com.opsec.api.dao;

import com.opsec.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * This class is responsible for handling the user specific information based on different request param
 * And using the help of UserRepository save the data into MongoDb
 */

@Component
public class UserDao {
    private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserDao.class);


    @Autowired
    private UserRepository userRepository;

    /**
     * This method persist the user information in MongoDb
     *
     * @param user
     * @return User
     */

    public User insertUserData(User user) {
        logger.info(" process request {}", user);
        User response = null;
        try {
            response = userRepository.insert(user);
        } catch (Exception e) {

        }
        return response;
    }

    /**
     * This method get all the user data from Mongo db
     *
     * @return Collection<User>
     */
    public Collection<User> getAllUserInformation() {
        logger.info(" process request for getAllUserInformation method{}");
        return userRepository.findAll();
    }

    /**
     * This method get  the user data from Mongo db based on specific id provide in param
     *
     * @param id
     * @return Optional<User>
     */

    public Optional<User> getUserInformationById(String id) {
        logger.info(" process request for getAllUserInformation method{}", id);
        return userRepository.findById(id);
    }

    /**
     * This method call the userRepository and fetch the result based on id
     *
     * @param id
     * @param user request payload object
     * @return User response object
     */
    public User updateUserUsingId(String id, User user) {
        logger.info(" process request for updateUserUsingId method{} and request payload", id, user);
        Optional<User> findPersonQuery = userRepository.findById(id);
        User personValues = findPersonQuery.get();
        personValues.setId(user.getId());
        personValues.setFirstName(user.getFirstName());
        personValues.setSurName(user.getSurName());
        personValues.setDob(user.getDob());
        personValues.setTitle(user.getTitle());
        return userRepository.save(personValues);
    }

    /**
     * This method delete the user information  based on id
     * doesn't return anything
     *
     * @param id
     */

    public void deleteUserUsingId(String id) {
        try {
            userRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

}
