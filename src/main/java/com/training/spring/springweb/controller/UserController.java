package com.training.spring.springweb.controller;

import com.training.spring.springweb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path =  "/users")
public class UserController {

    @Autowired
    @Qualifier("users")
    private List<User> users;


    @Autowired
    @Qualifier("second_users")
    private List<User> secondusers;

    @GetMapping
    public List<User> getAllUsers(){
        return users;
    }

    @GetMapping(path = "{first-name}")
//    @RequestMapping(path = "/{first-name}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public User getUserByFirstName(@PathVariable(value="first-name") String name){
        for(User user :users){
            if(user.getFirstName().equalsIgnoreCase(name)){
                return user;
            }
        }
        return null;
    }

    @GetMapping(path = "/surname")
//    localhost:8080/users/surname?last-name=Jengjet
//    @RequestMapping(path = "/surname/{last-name}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public User getUserByLastName(@RequestParam(value="last-name") String name){
        for(User user :users){
            if(user.getLastName().equalsIgnoreCase(name)){
                return user;
            }
        }
        return null;
    }

    @PostMapping
//    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public User addUser(@RequestBody User user){
        users.add(user);
        return user;
    }
}
