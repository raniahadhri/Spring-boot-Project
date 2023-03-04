package tn.spring.springboot.service.Moniteur;
import tn.spring.springboot.model.Moniteur;
import java.util.List;

public interface IMoniteurService {
    List<Moniteur> retrieveAllMoniteurs();
    Moniteur addOrUpdateMoniteur(Moniteur moniteur);

    void removeMoniteur (Moniteur moniteur);

    Moniteur retrieveMoniteur (Long numMoniteur);
    Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse);
}
