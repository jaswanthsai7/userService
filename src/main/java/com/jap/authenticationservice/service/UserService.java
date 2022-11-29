package com.jap.authenticationservice.service;


import com.jap.authenticationservice.domain.User;
import com.jap.authenticationservice.exception.UserCredentialsInvalidException;
import com.jap.authenticationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserByUserNameAndPassword(String userName,String password) throws UserCredentialsInvalidException {
        User user= this.userRepository.findByUserNameAndPassword(userName,password);
        if(user==null){
            throw new UserCredentialsInvalidException();
        }else {
            return user;
        }
    }

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(int id) {
        return this.userRepository.findById(id);
    }
}
