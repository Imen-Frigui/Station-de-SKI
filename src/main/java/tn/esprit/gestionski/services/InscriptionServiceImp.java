package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;

import java.util.List;

@Service
@AllArgsConstructor
public class InscriptionServiceImp implements Iinscription {

    public SkieurServiceImp skieurServiceImp;
    public InscriptionServiceImp inscriptionServiceImp;

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
    public Inscription addInscriptionAndAssignToSkieur(Inscription inscription, long numSkieur) {
        Skieur sk = skieurServiceImp.getById(numSkieur);
       // inscription.setSkieur(sk);
        sk.getInscriptionSet().add(inscription);
        skieurServiceImp.updateSkieur(sk);
        return inscription;
    }
}
