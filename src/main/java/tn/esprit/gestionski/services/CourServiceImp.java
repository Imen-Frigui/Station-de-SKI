package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.repositories.CourRepository;
import tn.esprit.gestionski.repositories.InscriptionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CourServiceImp implements Icour{
    public InscriptionRepository inscriptionRepository;
    public CourRepository courRepository;
    @Override
    public Cours addCours(Cours c) {
        return courRepository.save(c);
    }

    @Override
    public Cours updateCours(Cours c) {
        return courRepository.save(c);
    }

    @Override
    public List<Cours> getAllCours() {
        return courRepository.findAll();
    }

    @Override
    public Cours getById(long id) {
        return courRepository.getById(id);
    }

    @Override
    public void deleteCours(long id) {
        Cours c = courRepository.getById(id);
        courRepository.delete(c);
    }

    @Override
    public Inscription addInscriptionAndAssignToCours(Inscription inscription, Long numCour) {
        Cours cour = courRepository.getById(numCour);
        inscription.setCour(cour);
        return inscriptionRepository.save(inscription);
    }
}
