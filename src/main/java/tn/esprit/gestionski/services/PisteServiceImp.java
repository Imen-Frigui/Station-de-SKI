package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Piste;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.repositories.PisteRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class PisteServiceImp implements Ipiste{
    public SkieurRepository skieurRepository;
    public PisteRepository pisteRepository;

    @Override
    public Cours addPiste(Cours c) {
        return null;
    }

    @Override
    public Cours updatePiste(Cours c) {
        return null;
    }

    @Override
    public List<Cours> getAllPistes() {
        return null;
    }

    @Override
    public Cours getById(long id) {
        return null;
    }

    @Override
    public void deletePiste(long id) {

    }

    @Override
    public Skieur AssignSkieurToPiste(Long numSkieur, Long numPiste) {
        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);
        Piste piste = pisteRepository.findById(numPiste).orElse(null);
        skieur.getPisteSet().add(piste);
        piste.getSkieurSet().add(skieur);
        // skieur.getPisteSet().add(piste);
        skieurRepository.save(skieur);
        pisteRepository.save(piste);

        return skieur;

    }


}
