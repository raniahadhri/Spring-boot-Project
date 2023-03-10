package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.spring.springboot.model.Piste;

@Repository
public interface IPisteRepository extends JpaRepository<Piste, Long> {

}
