package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.TypeAbonnement;

import java.util.List;

public interface Iskieur {
    public Skieur addSkieur(Skieur S);
    public Skieur updateSkieur(Skieur S);
    public List<Skieur> getAllSkieurs();
    public Skieur getById(long id);
    public void deleteSkieur (long id);
    public Skieur addSkieurAndAssignToCour(Skieur skieur, long numCour);
    public List<Skieur> findByAbonnement(TypeAbonnement abonnement);

}
