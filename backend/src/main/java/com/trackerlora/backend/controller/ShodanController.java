package com.trackerlora.backend.controller;

import com.trackerlora.backend.entity.Shodan;
import com.trackerlora.backend.repository.ShodanRepository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shodan")
@CrossOrigin(origins = " ", allowedHeaders = " ")
public class ShodanController {

        @Autowired
        private ShodanRepository repository;

        @GetMapping()
        @CrossOrigin(origins = " ", allowedHeaders = " ")
        public Map<String, Object> getUsername() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("username", authentication.getName());
            userMap.put("error", false);
            return userMap;
        }

        @PostMapping()
        @CrossOrigin(origins = " ", allowedHeaders = " ")
        public Shodan createShodan(@RequestBody Shodan shodan) {
            return repository.save(shodan);
        }

        @PutMapping()
        @CrossOrigin(origins = " ", allowedHeaders = " ")
        public Shodan updateShodan(@PathVariable int uuid, @RequestBody Shodan shodan) {
            return repository.save(shodan);
        }

        @DeleteMapping()
        @CrossOrigin(origins = " ", allowedHeaders = " ")
        public void deleteShodan(@PathVariable("uuid") String uuid) {
            repository.deleteByUuid(uuid);
        }


}