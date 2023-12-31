package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.TypeAbonnement;
import tn.esprit.gestionski.services.InscriptionServiceImp;
import tn.esprit.gestionski.services.Iskieur;
import tn.esprit.gestionski.services.SkieurServiceImp;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
public class SkieurController {

    public Iskieur skieurServiceImp;

    @PostMapping("/addSk")
    public Skieur addSkieur(@RequestBody Skieur s){
        return skieurServiceImp.addSkieur(s);
    }

    @PutMapping("/editSk/{id}")
    public Skieur updateSkieur(@RequestBody Skieur s, @PathVariable long id){
        return skieurServiceImp.updateSkieur(s);
    }

    @GetMapping("/get")
    public List<Skieur> findAllSkieur(){
        return skieurServiceImp.getAllSkieurs();
    }

    @GetMapping("/getSk/{Id}")
    public Skieur findSkieurById(@PathVariable long Id){
        return  skieurServiceImp.getById(Id);
    }

    @DeleteMapping("/delete/{Id}")
    public void deleteSkieurById(@PathVariable long Id){
        skieurServiceImp.deleteSkieur(Id);
    }

    @PostMapping("/assignskieur/{numCour}")
    public Skieur addSkieurAnAssignToCour (@RequestBody Skieur skieur, @PathVariable long numCour){
        return skieurServiceImp.addSkieurAndAssignToCour(skieur,numCour);
    }
    @GetMapping("/getSkByAnbonnement/{abonnement}")
    public List<Skieur> findSkieurByAbonnement(@PathVariable TypeAbonnement abonnement){
        return  skieurServiceImp.findByAbonnement(abonnement);
    }


}
