package tn.spring.springboot.service.Cours;

import tn.spring.springboot.model.Cours;
import java.util.List;

public interface ICoursService {
    List<Cours> retrieveAllCourses();
    Cours addOrUpdateCours(Cours cours);

    void removeCours (Cours cours);

    Cours retrieveCours (Long numCours);
}
