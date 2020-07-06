package com.massad.todo.service;

import com.massad.todo.domaine.User;
import com.massad.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserbyId(int id){
        return userRepository.findById(id);
    }

    public User getUserByUsername(String usr){
        return userRepository.findByUsername(usr);
    }

    public User createUser(User t){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        t.setPassword(bCryptPasswordEncoder.encode(t.getPassword()));
        return userRepository.save(t);
    }

    public void deleteUser(User t){
        userRepository.delete(t);
    }

    public User updateUser(User t){
        return userRepository.save(t);
    }
}
