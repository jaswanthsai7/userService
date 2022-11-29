package com.jap.authenticationservice.repository;

import com.jap.authenticationservice.domain.User;
import com.jap.authenticationservice.exception.UserCredentialsInvalidException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserNameAndPassword(String userName,String Password) throws UserCredentialsInvalidException;
}
