package tn.esprit.gestionski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.gestionski.entities.Inscription;
import tn.esprit.gestionski.entities.Support;

import java.util.Date;
import java.util.List;

public interface InscriptionRepository  extends JpaRepository<Inscription, Long> {
    List<Inscription> findByNumSemaine(int numSemaine);

}
