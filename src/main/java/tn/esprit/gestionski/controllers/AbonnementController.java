package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.TypeAbonnement;
import tn.esprit.gestionski.services.IAbonnement;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
public class AbonnementController {
    IAbonnement iAbonnement;


    @GetMapping("/getAbonnementTypeAndDate/{t}")
    public List<Abonnement> getAbonnementTypeAndDate(@PathVariable TypeAbonnement t) {
        return iAbonnement.getAbonnementTypeAndDate(t);
    }

    @GetMapping("/getAbonnementByDate/{debut}/{fin}")
    public List<Abonnement> getAbonnementByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date debut, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fin) {
        return iAbonnement.findAbonnementBetweenDateDebutDateFin(debut,fin);
    }
}
