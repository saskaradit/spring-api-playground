package com.training.spring.springweb.bean;

import com.training.spring.springweb.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanConfiguration {

    @Bean(name = "users")
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        User user = new User("Thomas","Shelby",34, "Birmingham");
        users.add(user);
        return users;
    }

    @Bean(name = "second_users")
    public List<User> getSecondUsers(){
        List<User> users = new ArrayList<>();
        User user = new User("Michael","Gray",28, "London");
        users.add(user);
        return users;
    }
}
