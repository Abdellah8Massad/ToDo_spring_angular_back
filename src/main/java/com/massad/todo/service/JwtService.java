package com.massad.todo.service;

import com.massad.todo.domaine.User;
import com.massad.todo.dto.JwtResponse;
import com.massad.todo.dto.UserDetail;
import com.massad.todo.repoRedis.JwtResponseRepository;
import com.massad.todo.repository.UserRepository;

import java.util.List;

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
    
    @Autowired
    JwtResponseRepository jwtResponseRepository ;

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
    
    public void addSessionJWT(JwtResponse jwtResponse) {
    	jwtResponseRepository.save(jwtResponse);
    }
    
    
    public JwtResponse getSessionJWT(String name) {
    	return jwtResponseRepository.findByUsername(name);
    }
    
    public List<JwtResponse> getALLsessions(){
    	return (List<JwtResponse>) jwtResponseRepository.findAll();
    }
}
