package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.TypeAbonnement;

import java.util.Date;
import java.util.List;

public interface IAbonnement {
    public List<Abonnement> getAbonnementTypeAndDate(TypeAbonnement T);

    List<Abonnement> findAbonnementBetweenDateDebutDateFin(Date dateDebut , Date dateFin);
}
