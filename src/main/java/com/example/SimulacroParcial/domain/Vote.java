package com.example.SimulacroParcial.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.util.Objects.isNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "votos")
public class Vote {

    @Id
    @GeneratedValue
    private Integer id;
    private LocalDateTime date;
    @ManyToOne(fetch = FetchType.LAZY) //matchea la db
    @JoinColumn(name = "candidate_id", referencedColumnName = "id") //inner join
    @JsonIgnore //que la entidad de abajo no aparezca en el json
    private Candidate candidate;

    @PrePersist //se ejecuta antes de que se persista en la base de datos
    public void setTime() {
        if (isNull(this.getDate())) {
            this.date = LocalDateTime.now();
        }
    }
}
