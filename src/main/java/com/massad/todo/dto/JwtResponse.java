package com.massad.todo.dto;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("JwtResponse")
public class JwtResponse implements Serializable {

    private String token;
    private String nom;
    private String prenom;
    private String username;
    private int id;

    public JwtResponse(String token, UserDetail userDetail){
        this.token = token;
        this.nom = userDetail.getNom();
        this.prenom = userDetail.getPrenom();
        this.username = userDetail.getUsername();
        this.id = userDetail.getId();
    }
    
    public JwtResponse() {
    	
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
