package com.opsec.api.client;

import com.opsec.api.model.User;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/** FeignClient used to call the core service from composite service
 *
 */

@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "user-core")
public interface UserCoreClient {

    /**
     * Interface method to get the greetings information from a different microservice.
     *
     * @return List<User>
     */
    @GetMapping(value = "/user-core/user-core-service/getAllInfo")
    public List<User> getAllUserInformation();


    @PostMapping(value = "/user-core/user-core-service/createUser")
    User insertUserData(User person);

    @GetMapping(path = "/user-core/user-core-service/{id}")
    Optional<User> getUserInformationUsingId(@PathVariable("id") String id);

    @PutMapping(path = "/user-core/user-core-service/update/{id}")
    void updateUserUsingId(@PathVariable String id, @RequestBody User user);

    @DeleteMapping(path = "/user-core/user-core-service/delete/{id}")
    void deleteUserUsingId(@PathVariable("id") String id);

}
