package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.spring.springboot.model.Cours;

@Repository
public interface ICoursRepository extends JpaRepository<Cours, Long> {

}
