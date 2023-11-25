package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Support;
import tn.esprit.gestionski.services.Iinscription;

import java.util.List;

@RestController
@AllArgsConstructor
public class InscriptionController {
    public Iinscription iinscription;

    @PostMapping("/{numSkieur}/inscription")
    public Inscription addInscriptionAndAssignToSkieur(@RequestBody Inscription inscription, @PathVariable Long numSkieur) {
        iinscription.addInscriptionAndAssignToSkieur(inscription,numSkieur);
        return inscription;

    }
    @PostMapping("/addInscription/{numSkieur}/{numCours}")
    public Inscription addInscriptionAndAssignToSkierAndCourse(@RequestBody Inscription inscription, @PathVariable Long numSkieur, @PathVariable Long numCours) {
        Inscription addedInscription = iinscription.addRegistrationAndAssignToSkierAndCourse(inscription, numSkieur, numCours);
        return addedInscription;

    }
    @PostMapping("/calcul")
    public ResponseEntity<String> triggerSubscriptionRetrieval() {
        iinscription.calculateMrr();
        return ResponseEntity.ok("calcul triggered successfully. Check the logs for details.");
    }


}
