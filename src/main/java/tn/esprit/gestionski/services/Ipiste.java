package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;

import java.util.List;

public interface Ipiste {
    public Cours addPiste(Cours c);

    public Cours updatePiste(Cours c);

    public List<Cours> getAllPistes();

    public Cours getById(long id);

    public void deletePiste(long id);

    public Skieur AssignSkieurToPiste(Long numskieur, Long numPiste);
}
