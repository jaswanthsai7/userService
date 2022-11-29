package com.jap.authenticationservice.service;

import com.jap.authenticationservice.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(User user);
}
