package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.spring.springboot.model.Abonnement;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface IAbonnementRepository extends JpaRepository<Abonnement, Long> {
   List<Abonnement> findAbonnementsByDateDebutAndDateFin(LocalDate startDate, LocalDate endDate);
}
