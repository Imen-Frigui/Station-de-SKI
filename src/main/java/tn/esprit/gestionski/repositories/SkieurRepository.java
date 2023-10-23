package tn.esprit.gestionski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestionski.entities.Skieur;

public interface SkieurRepository extends JpaRepository<Skieur, Long> {
}
