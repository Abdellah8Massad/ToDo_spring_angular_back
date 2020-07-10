package com.massad.todo.repoRedis;

import com.massad.todo.dto.JwtResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtResponseRepository extends CrudRepository<JwtResponse,String> {
	JwtResponse findByUsername(String name);
}
