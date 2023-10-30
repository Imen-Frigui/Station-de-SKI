package tn.esprit.gestionski.services;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;

import java.util.List;

public interface Iinscription {
        public Inscription addInscription(Inscription S);

        public Inscription updateInscription(Inscription S);

        public List<Inscription> getAllInscription();

        public Inscription getById(long id);

        public void deleteInscription(long id);

        public Inscription addInscriptionAndAssignToSkieur(Inscription inscription, long numSkieur);
}
