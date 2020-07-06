package com.massad.todo.service;

import com.massad.todo.domaine.Tache;
import com.massad.todo.repository.TacheRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TacheService {

    public static final Logger LOGGER = LogManager.getLogger(JwtService.class);

    @Autowired
    private TacheRepository tacheRepository;

    public List<Tache> getTaches(){
        return tacheRepository.findAll();
    }

    public Optional<Tache> getTachebyId(int id){
        return tacheRepository.findById(id);
    }

    public Tache getTacheTitle(String title){
        return tacheRepository.findByTitre(title);
    }

    public Tache createTache(Tache t){
        return tacheRepository.save(t);
    }

    public void deleteTache(int id){
        tacheRepository.deleteById(id);
    }

    public Tache updateTache(Tache t){
        return tacheRepository.save(t);
    }
}
