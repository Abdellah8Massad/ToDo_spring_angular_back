package com.massad.todo.controller;

import com.massad.todo.domaine.Tache;
import com.massad.todo.dto.UserDetail;
import com.massad.todo.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin
@RestController
public class TacheController {

    @Autowired
    TacheService tacheService;

    @GetMapping("/tache")
    public List<Tache> getAllTaches(){
        return tacheService.getTaches();
    }

    @PostMapping(path = "/tache", consumes = "application/json", produces = "application/json")
    public void createTache(@RequestBody Tache tache){
        tacheService.createTache(tache);
    }

    @PutMapping(path = "/tache", consumes = "application/json", produces = "application/json")
    public Tache updateTache(@RequestBody Tache tache){
        return tacheService.updateTache(tache);
    }

    @DeleteMapping(path = "/tache/{id}", consumes = "application/json", produces = "application/json")
    public void deleteTache(@PathVariable Integer id){
        System.out.println("la valeur de l'id a supprimé est : "+ id);
        if(id != null)
        tacheService.deleteTache(id);
    }

    @GetMapping("/tache/usercurrent")
    public ResponseEntity<?> userConnected(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetail currentPrincipalName = (UserDetail) authentication.getPrincipal();
        return ResponseEntity.ok(currentPrincipalName);
    }

}

