package com.example.SimulacroParcial.repository;

import com.example.SimulacroParcial.domain.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryCandidates extends JpaRepository<Candidate,Integer> {
}
