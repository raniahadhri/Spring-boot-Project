package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.spring.springboot.model.Piste;

public interface IPisteRepository extends JpaRepository<Piste, Long> {
}
