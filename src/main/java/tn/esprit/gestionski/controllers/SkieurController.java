package tn.esprit.gestionski.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.services.SkieurServiceImp;

import java.util.List;

@RestController
@AllArgsConstructor
public class SkieurController {

    public SkieurServiceImp skieurServiceImp;

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
}
