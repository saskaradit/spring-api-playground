package com.training.spring.springweb.service.impl;

import com.training.spring.springweb.entity.User;
import com.training.spring.springweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService implements IUserService {

    @Autowired
    @Qualifier("users")
    private List<User> users;

//    @Autowired
//    @Qualifier("second_users") --->> harus persis di bean, dan gaboleh duplikat
//    private List<User> secondusers;

    public User getUserByFirstName(String name){
        for(User user :users){
            if(user.getFirstName().equalsIgnoreCase(name)){
                return user;
            }
        }
        return null;
    }

    public User getUserBySurname(String name){
        for(User user :users){
            if(user.getLastName().equalsIgnoreCase(name)){
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers(){
        return users;
    }

    public User addUser(User user){
        users.add(user);
        return user;
    }
}
