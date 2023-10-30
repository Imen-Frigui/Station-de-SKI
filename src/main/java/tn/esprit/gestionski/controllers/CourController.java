package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.services.Icour;

@RestController
@AllArgsConstructor
public class CourController {
    public Icour icour;

    @PostMapping("/{numCour}/inscription")
    public Inscription addInscriptionAndAssignToCour(@RequestBody Inscription inscription, @PathVariable Long numCour) {
        return icour.addInscriptionAndAssignToCours(inscription,numCour);
    }
}
