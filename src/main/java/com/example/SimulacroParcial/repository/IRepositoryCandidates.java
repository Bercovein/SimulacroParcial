package com.example.SimulacroParcial.repository;

import com.example.SimulacroParcial.domain.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryCandidates extends JpaRepository<Candidate,Integer> {
    @Query (value = "delete from votos where date < SUBTIME(CUR_TIME(),'0:5:0')", nativeQuery = true)
    void deleteTimer();
}
