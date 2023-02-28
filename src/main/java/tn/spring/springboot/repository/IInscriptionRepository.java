package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.spring.springboot.model.Inscription;

@Repository
public interface IInscriptionRepository extends JpaRepository<Inscription, Long> {

}
