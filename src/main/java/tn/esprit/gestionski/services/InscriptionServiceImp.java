package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.repositories.InscriptionRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class InscriptionServiceImp implements Iinscription {

    public SkieurRepository skieurRepository;
    public InscriptionRepository inscriptionRepository;

    @Override
    public Inscription addInscription(Inscription S) {
        return null;
    }

    @Override
    public Inscription updateInscription(Inscription S) {
        return null;
    }


    @Override
    public List<Inscription> getAllInscription() {
        return null;
    }

    @Override
    public Inscription getById(long id) {
        return null;
    }

    @Override
    public void deleteInscription(long id) {

    }

    @Override
    public Inscription addInscriptionAndAssignToSkieur(Inscription inscription, Long numSkieur) {
        Skieur sk = skieurRepository.findById(numSkieur).orElse(null);
        inscription.setSkieur(sk);
        //sk.getInscriptionSet().add(inscription);
        return inscriptionRepository.save(inscription);
        //return inscription;
    }
}
