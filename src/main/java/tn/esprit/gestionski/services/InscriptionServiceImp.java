package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.entities.TypeCours;
import tn.esprit.gestionski.repositories.CourRepository;
import tn.esprit.gestionski.repositories.InscriptionRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;

@Service
@AllArgsConstructor
public class InscriptionServiceImp implements Iinscription {

    public SkieurRepository skieurRepository;
    public InscriptionRepository inscriptionRepository;
    public CourRepository courRepository;

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

    private int calculateAge(Date dateOfBirth) {
        if (dateOfBirth == null) {
            return 0;
        }

        java.util.Date utilDate = new java.util.Date(dateOfBirth.getTime());

        LocalDate birthDate = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDate currentDate = LocalDate.now();

        return Period.between(birthDate, currentDate).getYears();
    }

}
