package com.jap.authenticationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Login credentials Invalid ")
public class UserCredentialsInvalidException extends Exception{
}
