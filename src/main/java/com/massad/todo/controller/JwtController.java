package com.massad.todo.controller;
import com.massad.todo.configuration.JwtTokenUtil;
import com.massad.todo.dto.JwtRequest;
import com.massad.todo.dto.JwtResponse;
import com.massad.todo.dto.UserDetail;
import com.massad.todo.service.JwtService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/api/authenticate")
public class JwtController {

    public static final Logger LOGGER = LogManager.getLogger(JwtController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        LOGGER.info("Tentative d'authentification de l'utilisateur {}",jwtRequest.toString());

        try{
            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        }catch (Exception e){
            LOGGER.error("probleme d'authentification user : {}",e.getMessage());
            return ResponseEntity.ok("ko");
        }

        LOGGER.info("Authenticated true");
        UserDetail userDetail = jwtService.loadUserByUsername(jwtRequest.getUsername());
        LOGGER.info("user details");
        final String token = jwtTokenUtil.generateToken(userDetail);
        jwtService.addSessionJWT(new JwtResponse(token,userDetail));
        return ResponseEntity.ok(new JwtResponse(token,userDetail));
    }

    @GetMapping(path = "/user", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> findUserName(@RequestHeader("Authorization") String token){
        System.out.println("-------------------------- token : " + token);
        String[] bearer = token.split(" ");
        token = bearer[1];
        return ResponseEntity.ok(jwtTokenUtil.getUsernameFromToken(token));
    }

    @GetMapping(path = "/redis/{username}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getRedisUser(@PathVariable String username){
        if(username != null) {
        	LOGGER.info(" --------------- Username : {} --------------- jwtService {} ", username,jwtService.getSessionJWT(username));
            return ResponseEntity.ok(jwtService.getSessionJWT(username));        	
        }else
            return null;
    }

    @GetMapping(path = "/redisall", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getRedisALLUser(){
            return ResponseEntity.ok(jwtService.getALLsessions());
    }

    //releve les exception lies a l'utilisateur (expire,badrequest,password not valid..)
    private void authenticate(String username, String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        } catch(Exception e){
            LOGGER.error("Erreur d'authentification {}",e.getStackTrace());
            throw new Exception("Erreur login user : " + e.getMessage());
        }

    }



}
