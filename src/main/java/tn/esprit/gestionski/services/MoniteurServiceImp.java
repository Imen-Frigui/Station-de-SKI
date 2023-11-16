package tn.esprit.gestionski.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Moniteur;
import tn.esprit.gestionski.repositories.CourRepository;
import tn.esprit.gestionski.repositories.MoniteurRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class MoniteurServiceImp implements Imoniteur{
    private MoniteurRepository moniteurRepository;
    private CourRepository courRepository;
    @Override
    public Moniteur addMoniteurAndAssignToCour(Moniteur moniteur, long numCour) {
        Cours cour = courRepository.findById(numCour).orElse(null);
        Set<Cours> coursList = new HashSet<>();
        coursList.add(cour);
        moniteur.setCoursSet(coursList);
        return moniteurRepository.save(moniteur);

    }
}
