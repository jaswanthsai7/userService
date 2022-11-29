package com.jap.authenticationservice.controller;

import com.jap.authenticationservice.domain.User;
import com.jap.authenticationservice.exception.UserCredentialsInvalidException;
import com.jap.authenticationservice.service.IUserService;
import com.jap.authenticationservice.service.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private IUserService iUserService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(IUserService iUserService, SecurityTokenGenerator securityTokenGenerator) {
        this.iUserService = iUserService;
        this.securityTokenGenerator = securityTokenGenerator;
    }


    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(this.iUserService.saveUser(user), HttpStatus.OK);

    }

    @GetMapping("api/v1/getall")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(this.iUserService.getAll(), HttpStatus.OK);
    }

    @GetMapping("api/v1/getbyid/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(this.iUserService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<?> getUserByUserNameAndPassword(@RequestBody User user) throws UserCredentialsInvalidException {
        try {
            new ResponseEntity<>(this.iUserService.getUserByUserNameAndPassword(user.getUserName(), user.getPassword()), HttpStatus.OK);
            Map<String, String> key = new HashMap<>();
            key= this.securityTokenGenerator.generateToken(user);
            return new ResponseEntity<>(key, HttpStatus.OK);
        } catch (UserCredentialsInvalidException e) {
            throw new UserCredentialsInvalidException();
        }
    }

}