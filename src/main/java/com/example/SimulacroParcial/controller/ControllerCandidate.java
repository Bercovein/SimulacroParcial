package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.domain.Candidate;
import com.example.SimulacroParcial.domain.Vote;
import com.example.SimulacroParcial.repository.IRepositoryCandidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/candidate")
@RestController
public class ControllerCandidate {

    @Autowired
    IRepositoryCandidates candidates;

    /* [POST] /candid"atos/  Dar de alta 1 candidato.*/
    @PostMapping("")
    public void addCandidate(@RequestBody Candidate candidate){

        candidates.save(candidate);
    }

    /*[GET] /candidatos/ Devolver los candidatos.*/
    @GetMapping("")
    public List<Candidate> getAll(){

        return candidates.findAll();
    }

    /*[GET] /candidatos/{id} Devolver candidato id 1.*/
    @GetMapping ("/{id}")
    public Candidate getById(@PathVariable ("id") Integer id) throws Exception {

        return candidates.findById(id).orElseThrow(
                () -> new Exception(
                        String.format("No se pudo encontrar el candidato"))); //exception en caso de que no exista
    }

    /*[POST] /votes/{idCandidato} Votar al candidato N° 1.*/
    @PostMapping("votes/{id}")
    public void voteCandidateById(@PathVariable ("id") Integer id,@RequestBody Vote voto) throws Exception {
        Candidate candi = candidates.findById(id).orElseThrow(
                () -> new Exception( String.format("No se pudo encontrar el candidato")));

        candi.getVotes().add(voto);
        voto.setCandidate(candi);

        candidates.save(candi);
    }

    /*[GET] /votes devolver candidatos con sus respectivos votos.*/
    //

    //Generar un Scheduler para eliminar los votos que fueron realizados hace mas de 5 minutos.
    @Scheduled(cron =  "0 5 0 * * *")
    public void eliminarVotos() {
        candidates.deleteTimer();
    }
}
