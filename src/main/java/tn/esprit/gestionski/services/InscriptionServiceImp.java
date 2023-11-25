package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.*;
import tn.esprit.gestionski.repositories.AbonnementRepository;
import tn.esprit.gestionski.repositories.CourRepository;
import tn.esprit.gestionski.repositories.InscriptionRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;


@Service
@AllArgsConstructor
public class InscriptionServiceImp implements Iinscription {

    public SkieurRepository skieurRepository;
    public InscriptionRepository inscriptionRepository;
    public CourRepository courRepository;
    public AbonnementRepository abonnementRepository;

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

    @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours) {

        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);
        Cours cours = courRepository.findById(numCours).orElse(null);


        if (cours.getTypeCours() == TypeCours.COLLECTIF_ENFANT || cours.getTypeCours() == TypeCours.COLLECTIF_ADULT) {

            if (cours.getInscriptionSet().size() >= 6) {
                return null;
            }
        }

        int skieurAge = calculateAge((Date) skieur.getDateNaissance());
        if (skieurAge < cours.getNieau()) {
            return null;
        }

        inscription.setSkieur(skieur);
        inscription.setCour(cours);
        courRepository.save(cours);
        skieurRepository.save(skieur);


        return inscriptionRepository.save(inscription);
    }


    private  Date calculateEndDateThreshold(Date currentDate) {
        long endDateMillis = currentDate.getTime() + (7L * 24L * 60L * 60L * 1000L);
        return new Date(endDateMillis);
    }

    private int calculateAge(Date dateOfBirth) {
        if (dateOfBirth == null) {
            return 0;
        }

        java.util.Date utilDate = new java.util.Date(dateOfBirth.getTime());

        LocalDate birthDate = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDate currentDate = LocalDate.now();

        return Period.between(birthDate, currentDate).getYears();
    }

    @Override
    @Scheduled(cron = "0 0 0 1 * ?")
    public void calculateMrr() {
        Date currentDate = new Date();
        Date endDateThreshold = calculateEndDateThreshold(currentDate);

        List<Abonnement> endingSubscriptions = abonnementRepository.findAbonnementByDateDebutBetween(currentDate, endDateThreshold);

        for (Abonnement abonnement : endingSubscriptions) {
            List<Skieur> skieurs = skieurRepository.findByAbonnement_TypeAbon(abonnement.getTypeAbon());

            for (Skieur skieur : skieurs) {
                System.out.println("Subscription Number: " + abonnement.getNumAbon());
                System.out.println("Skieur Information - NumSkieur: " + skieur.getNumSkieur() +
                        ", FirstName: " + skieur.getNomS() +
                        ", LastName: " + skieur.getPrenomS());
            }
        }
    }

}
