package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.TypeAbonnement;
import tn.esprit.gestionski.repositories.AbonnementRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class AbonnementServicImp implements IAbonnement{
    AbonnementRepository repository ;
    @Override
    public List<Abonnement> getAbonnementTypeAndDate(TypeAbonnement T) {
        return repository.getAbonnementByTypeAbonOrderByDateDebut(T);
    }

    @Override
    public List<Abonnement> findAbonnementBetweenDateDebutDateFin(Date dateDebut, Date dateFin) {
        return repository.findAbonnementByDateDebutBetween(dateDebut,dateFin);
    }
}
