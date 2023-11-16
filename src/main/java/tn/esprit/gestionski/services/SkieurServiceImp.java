package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.repositories.CourRepository;
import tn.esprit.gestionski.repositories.InscriptionRepository;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class SkieurServiceImp implements Iskieur{

    private SkieurRepository skieurRepository;
    private CourRepository courRepository;
    private InscriptionRepository inscriptionRepository;

    @Override
    public Skieur addSkieur(Skieur S) {
        return skieurRepository.save(S);
    }

    @Override
    public Skieur updateSkieur(Skieur S) {
        return skieurRepository.save(S);
    }

    @Override
    public List<Skieur> getAllSkieurs() {
        return skieurRepository.findAll();
    }

    @Override
    public Skieur getById(long id) {
        return skieurRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteSkieur(long id) {
        skieurRepository.deleteById(id);
    }

    @Override
    public Skieur addSkieurAndAssignToCour(Skieur skieur, long numCour) {
        Skieur skieur1 = skieurRepository.save(skieur);
        Cours cours = courRepository.findById(numCour).orElse(null);
        Set<Inscription> inscriptionList = skieur1.getInscriptionSet();
        for (Inscription i:inscriptionList){
            i.setSkieur(skieur1);
            i.setCour(cours);
            inscriptionRepository.save(i);
        }
        return skieur1;
    }


}
