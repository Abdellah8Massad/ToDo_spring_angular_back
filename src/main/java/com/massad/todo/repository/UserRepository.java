package com.massad.todo.repository;

import com.massad.todo.domaine.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByUsername(String usr);
}
