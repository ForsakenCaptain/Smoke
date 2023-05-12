package com.example.smoke.controller;

import com.example.smoke.models.User2;
import com.example.smoke.services.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class User2Controller {

    @Autowired
    private User2Service userService;

    @PostMapping("/addUser")
    public User2 addUser(@RequestBody User2 user){
        return userService.createUser(user);
    }

    @PostMapping("/addUsers")
    public List<User2> addUsers(@RequestBody List<User2> users){
        return userService.createUsers(users);
    }

    @PostMapping("/user/{id}")
    public User2 getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public List<User2> getAllUsers(){
        return userService.GetUsers();
    }

    @PostMapping("/updateUser")
    public User2 updateUser(@RequestBody User2 user){
        return userService.UpdateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public String DeleteUser(@PathVariable int id){
        return userService.DeleteUserById(id);
    }
}
