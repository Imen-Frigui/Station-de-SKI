package tn.esprit.gestionski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.gestionski.entities.Cours;

public interface CourRepository extends JpaRepository<Cours, Long> {
}
