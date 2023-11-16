package tn.esprit.gestionski.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Cours implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numCours;
    private int nieau;
    private TypeCours typeCours;
    private Support support;
    private  Float prix;
    private int creneau;
    @OneToMany(mappedBy = "cour")
    @JsonManagedReference
    private Set<Inscription> inscriptionSet;
}
