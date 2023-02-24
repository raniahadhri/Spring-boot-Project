package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.spring.springboot.model.Cours;

public interface ICoursRepository extends JpaRepository<Cours, Long> {

}
