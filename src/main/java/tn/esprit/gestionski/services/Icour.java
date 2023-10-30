package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Inscription;

import java.util.List;

public interface Icour {
    public Cours addCours(Cours c);

    public Cours updateCours(Cours c);

    public List<Cours> getAllCours();

    public Cours getById(long id);

    public void deleteCours(long id);

    public Inscription addInscriptionAndAssignToCours(Inscription inscription, Long numCour);
}
