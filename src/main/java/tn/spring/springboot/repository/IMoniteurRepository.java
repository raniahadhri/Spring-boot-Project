package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.spring.springboot.model.Moniteur;

public interface IMoniteurRepository extends JpaRepository<Moniteur, Long> {
}
