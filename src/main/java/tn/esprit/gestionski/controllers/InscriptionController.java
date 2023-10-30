package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.services.Iinscription;

@RestController
@AllArgsConstructor
public class InscriptionController {
    public Iinscription iinscription;

    @PostMapping("/{numSkieur}/inscription")
    public Inscription addInscriptionAndAssignToSkieur(@RequestBody Inscription inscription, @PathVariable Long numSkieur) {
        iinscription.addInscriptionAndAssignToSkieur(inscription,numSkieur);
        return inscription;

    }
}
