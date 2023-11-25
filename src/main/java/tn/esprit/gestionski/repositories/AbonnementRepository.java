package tn.esprit.gestionski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.TypeAbonnement;

import java.util.Date;
import java.util.List;

public interface AbonnementRepository extends JpaRepository<Abonnement, Integer> {
    List<Abonnement> getAbonnementByTypeAbonOrderByDateDebut(TypeAbonnement type);

    List<Abonnement> findAbonnementByDateDebutBetween(Date dateDebut , Date dateFin);
}
