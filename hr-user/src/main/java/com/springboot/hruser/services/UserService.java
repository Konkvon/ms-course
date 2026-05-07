package com.springboot.hruser.services;

import com.springboot.hruser.entities.User;
import com.springboot.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Objeto não encontrado"));
    }

    public User findByEmail(@RequestParam String email){
        Optional<User> obj = repository.findByEmail(email);
        return obj.orElseThrow(() -> new RuntimeException("Objeto não encontrado"));
    }
}
