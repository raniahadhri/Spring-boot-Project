package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.spring.springboot.enums.TypeAbonnement;
import tn.spring.springboot.model.Cours;
import tn.spring.springboot.model.Skieur;

import java.util.List;

@Repository
public interface ISkieurRepository extends JpaRepository<Skieur, Long> {

    List<Skieur> findByAbonnement_TypeAbon(TypeAbonnement typeAbonnement);

}
