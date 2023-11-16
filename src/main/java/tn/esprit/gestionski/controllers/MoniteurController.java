package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Moniteur;
import tn.esprit.gestionski.services.Icour;
import tn.esprit.gestionski.services.Imoniteur;

@RestController
@AllArgsConstructor
public class MoniteurController {
    public Imoniteur imoniteur;

    @PostMapping("/assignmoniteur/{numCour}")
    public Moniteur addMoniteurAndAssignToCour(@RequestBody Moniteur moniteur, @PathVariable long numCour){
        return imoniteur.addMoniteurAndAssignToCour(moniteur, numCour);
    }
}
