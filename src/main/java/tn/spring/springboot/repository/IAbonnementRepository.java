package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.spring.springboot.model.Abonnement;

@Repository
public interface IAbonnementRepository extends JpaRepository<Abonnement, Long> {

}
