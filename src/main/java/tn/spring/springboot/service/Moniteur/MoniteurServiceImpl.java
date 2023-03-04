package tn.spring.springboot.service.Moniteur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.model.Cours;
import tn.spring.springboot.model.Moniteur;
import tn.spring.springboot.repository.ICoursRepository;
import tn.spring.springboot.repository.IMoniteurRepository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MoniteurServiceImpl implements IMoniteurService{
    @Autowired
    private IMoniteurRepository moniteurRepository;

    @Autowired
    private ICoursRepository coursRepository;
    @Override
    public List<Moniteur> retrieveAllMoniteurs() {
        return moniteurRepository.findAll();
    }

    @Override
    public Moniteur addOrUpdateMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public void removeMoniteur(Moniteur moniteur) {
        moniteurRepository.delete(moniteur);
    }

    @Override
    public Moniteur retrieveMoniteur(Long numMoniteur) {
        return moniteurRepository.findById(numMoniteur)
                .orElseThrow(() -> new EntityNotFoundException("Moniteur not found with id " + numMoniteur));
    }

    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse) {
        Cours cours = coursRepository.findById(numCourse)
                .orElseThrow(() -> new EntityNotFoundException("Cours inexistant " + numCourse));
        if(moniteurRepository.findByCoursContaining(cours)){
            throw new EntityExistsException("Cours déja affecté à un moniteur");
        }
        moniteur.getCours().add(cours);
        return moniteurRepository.save(moniteur);
    }
}
