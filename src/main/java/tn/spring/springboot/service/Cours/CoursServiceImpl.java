package tn.spring.springboot.service.Cours;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.model.Cours;
import tn.spring.springboot.repository.ICoursRepository;
import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
public class CoursServiceImpl implements ICoursService{
    @Autowired
    private ICoursRepository coursRepository;
    @Override
    public List<Cours> retrieveAllCourses() {
        return coursRepository.findAll();
    }

    @Override
    public Cours addOrUpdateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public void removeCours(Cours cours) {
        coursRepository.delete(cours);
    }

    @Override
    public Cours retrieveCours(Long numCours) {
        return coursRepository.findById(numCours)
                .orElseThrow(() -> new EntityNotFoundException("Cours not found with id " + numCours));
    }
}
