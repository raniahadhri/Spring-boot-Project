package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.spring.springboot.model.Cours;
import tn.spring.springboot.model.Moniteur;


@Repository
public interface IMoniteurRepository extends JpaRepository<Moniteur, Long> {
    Boolean findByCoursContaining(Cours cours);
}
