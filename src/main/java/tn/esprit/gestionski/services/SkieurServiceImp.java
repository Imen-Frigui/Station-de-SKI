package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Skieur;
import tn.esprit.gestionski.repositories.SkieurRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SkieurServiceImp implements Iskieur{

    private SkieurRepository skieurRepository;

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
}
