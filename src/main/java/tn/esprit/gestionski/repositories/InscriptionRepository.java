package tn.esprit.gestionski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestionski.entities.Inscription;

public interface InscriptionRepository  extends JpaRepository<Inscription, Long> {
}
