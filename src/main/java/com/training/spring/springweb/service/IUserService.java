package com.training.spring.springweb.service;

import com.training.spring.springweb.entity.User;

import java.util.List;

public interface IUserService {
    User getUserByFirstName(String name);
    User getUserBySurname(String name);
    List<User> getAllUsers();
    User addUser(User user);
}
