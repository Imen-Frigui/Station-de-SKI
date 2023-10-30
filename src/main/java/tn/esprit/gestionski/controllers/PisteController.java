package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.gestionski.entities.Piste;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.services.Ipiste;

@RestController
@AllArgsConstructor
public class PisteController {
    public Ipiste ipiste;

    @PostMapping("/assign/{numSkieur}/{numPiste}")
    public Skieur AssignSkieurToPisteF(@PathVariable Long numSkieur, @PathVariable Long numPiste) {
        return ipiste.AssignSkieurToPiste(numSkieur,numPiste);
    }
}
