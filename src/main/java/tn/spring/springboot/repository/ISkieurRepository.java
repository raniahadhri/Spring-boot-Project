package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.spring.springboot.model.Skieur;

@Repository
public interface ISkieurRepository extends JpaRepository<Skieur, Long> {

}
