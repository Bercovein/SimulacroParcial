package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.domain.Candidate;
import com.example.SimulacroParcial.repository.IRepositoryCandidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/candidate")
@RestController
public class ControllerCandidate {

    @Autowired
    IRepositoryCandidates candidates;

    @PostMapping("")
    public void addCandidate(@RequestBody Candidate candidate){

        candidates.save(candidate);
    }

    @GetMapping("")
    public List<Candidate> getAll(){

        return candidates.findAll();
    }

    @GetMapping ("/{id}")
    public Optional<Candidate> getById( @RequestBody Integer id){

        return candidates.findById(id);
    }
}
