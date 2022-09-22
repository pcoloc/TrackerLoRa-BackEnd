package com.trackerlora.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.trackerlora.backend.entity.Power;

@CrossOrigin(origins = {"https://trackerlora.lopezcarrillo.com", "http://localhost:4200"})
public interface PowerRepository extends CrudRepository<Power, String> {

    Power findById(Integer id);

}
