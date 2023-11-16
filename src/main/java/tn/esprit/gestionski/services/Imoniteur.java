package tn.esprit.gestionski.services;

import tn.esprit.gestionski.entities.Cours;
import tn.esprit.gestionski.entities.Moniteur;

public interface Imoniteur {
    public Moniteur addMoniteurAndAssignToCour(Moniteur moniteur, long numCour);

}
