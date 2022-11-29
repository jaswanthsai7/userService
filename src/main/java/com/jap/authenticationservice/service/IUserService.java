package com.jap.authenticationservice.service;

import com.jap.authenticationservice.domain.User;
import com.jap.authenticationservice.exception.UserCredentialsInvalidException;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> getAll();
    User getUserByUserNameAndPassword(String userName,String password) throws UserCredentialsInvalidException;
    User saveUser(User user);

   Optional<User> getUserById(int id);
}
