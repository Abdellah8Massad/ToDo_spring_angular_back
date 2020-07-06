package com.massad.todo.controller;

import com.massad.todo.domaine.User;
import com.massad.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @PutMapping(path = "/user", consumes = "application/json", produces = "application/json")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping(path = "/User", consumes = "application/json", produces = "application/json")
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user);
    }
}
