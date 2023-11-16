package tn.esprit.gestionski.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Skieur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkieur;

    private String nomS;
    private String prenomS;
    @Temporal(TemporalType.DATE)
    private Date DateNaissance;
    private  String ville;

    @ManyToMany
    @JsonIgnore
    private Set<Piste> pisteSet;

    @OneToMany(mappedBy = "skieur", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Inscription> inscriptionSet;

    @OneToOne
    private Abonnement abonnement;
}
