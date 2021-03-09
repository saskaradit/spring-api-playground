package com.training.spring.springweb.repository.impl;

import com.training.spring.springweb.entity.User;
import com.training.spring.springweb.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepository implements IUserRepository {

    @Autowired
    @Qualifier("users")
    private List<User> users;

    @Override
    public List<User> getUsers() {
        return users;
    }
}
