package com.example.SimulacroParcial.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //crea tabla con el de abajo
@Table(name = "candidates") //lo mismo pero le da nombre a la tabla
public class Candidate {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //es como el auto_increment
    private Integer id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "candidate")
    //matchea en la db -- LAZY: No la carga mientras no la necesite,
    // si haces un get del proxy, te trae los datos
    //FetchType.EAGER trae todoo
    @ToString.Exclude
    private List<Vote> votes;

}
