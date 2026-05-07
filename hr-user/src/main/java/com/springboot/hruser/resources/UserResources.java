package com.springboot.hruser.resources;

import com.springboot.hruser.entities.User;
import com.springboot.hruser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "tb_user")
public class UserResources {
    @Autowired
    private UserService service;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    
    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        User obj = service.findByEmail(email);
        return ResponseEntity.ok().body(obj);
    }
}
