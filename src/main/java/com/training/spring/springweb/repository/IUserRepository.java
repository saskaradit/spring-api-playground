package com.training.spring.springweb.repository;

import com.training.spring.springweb.entity.User;

import java.util.List;

public interface IUserRepository {
    List<User> getUsers();
}
