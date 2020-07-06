package com.massad.todo.repository;

import com.massad.todo.domaine.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacheRepository extends JpaRepository<Tache,Integer> {

    public Tache findByTitre(String titre);
}
