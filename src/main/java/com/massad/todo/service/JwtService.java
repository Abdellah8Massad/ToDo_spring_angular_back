package com.massad.todo.service;

import com.massad.todo.domaine.User;
import com.massad.todo.dto.UserDetail;
import com.massad.todo.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class JwtService implements UserDetailsService  {

    public static final Logger LOGGER = LogManager.getLogger(JwtService.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("searching user {}",username);
        User user = userRepository.findByUsername(username);
        LOGGER.info("Recuperation de l'utilisateur UserDetail {}");
        if(user != null){
            return new UserDetail(user);
        }else
            return null;
    }
}
