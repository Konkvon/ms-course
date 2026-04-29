package com.springboot.hrworker.services;

import com.springboot.hrworker.entities.Worker;
import com.springboot.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository repo;

    public List<Worker> findAll(){
        return repo.findAll();
    }

    public Worker findById(Long id){
        Optional<Worker> obj = repo.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Objeto não encontrado"));
    }
}
