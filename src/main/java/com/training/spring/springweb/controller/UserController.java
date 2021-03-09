package com.training.spring.springweb.controller;

import com.training.spring.springweb.entity.User;
import com.training.spring.springweb.service.IUserService;
import com.training.spring.springweb.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path =  "/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(path = "{first-name}")
//    @RequestMapping(path = "/{first-name}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public User getUserByFirstName(@PathVariable(value="first-name") String name){
        return userService.getUserByFirstName(name);
    }

    @GetMapping(path = "/surname")
//    localhost:8080/users/surname?last-name=Jengjet
//    @RequestMapping(path = "/surname/{last-name}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public User getUserByLastName(@RequestParam(value="last-name") String name){
        return userService.getUserBySurname(name);
    }

    @PostMapping
//    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
