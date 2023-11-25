package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Abonnement;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.TypeAbonnement;
import tn.esprit.gestionski.repositories.AbonnementRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class AbonnementServicImp implements IAbonnement{
    AbonnementRepository abonnementRepository ;
    SkieurRepository skieurRepository;
    @Override
    public List<Abonnement> getAbonnementTypeAndDate(TypeAbonnement T) {
        return abonnementRepository.getAbonnementByTypeAbonOrderByDateDebut(T);
    }

    @Override
    public List<Abonnement> findAbonnementBetweenDateDebutDateFin(Date dateDebut, Date dateFin) {
        return abonnementRepository.findAbonnementByDateDebutBetween(dateDebut,dateFin);
    }
    @Override
    @Scheduled(cron = "0 0 0 * * ?")
    public void retrieveSubscriptions() {
        Date currentDate = new Date();
        Date endDateThreshold = calculateEndDateThreshold(currentDate);

        // Retrieve subscriptions ending in the next 7 days
        List<Abonnement> endingSubscriptions = abonnementRepository.findAbonnementByDateDebutBetween(currentDate, endDateThreshold);

        for (Abonnement abonnement : endingSubscriptions) {
            List<Skieur> skieurs = skieurRepository.findByAbonnement_TypeAbon(abonnement.getTypeAbon());

            for (Skieur skieur : skieurs) {
                // Display information or perform further processing
                System.out.println("Subscription Number: " + abonnement.getNumAbon());
                System.out.println("Skieur Information - NumSkieur: " + skieur.getNumSkieur() +
                        ", FirstName: " + skieur.getNomS() +
                        ", LastName: " + skieur.getPrenomS());
                // Add logic here to notify the responsible person, e.g., send an email
            }
        }
    }

    private Date calculateEndDateThreshold(Date currentDate) {
        // Calculate the date 7 days from the current date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        return calendar.getTime();
    }

}
