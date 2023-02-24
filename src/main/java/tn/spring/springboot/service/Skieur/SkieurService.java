package tn.spring.springboot.service.Skieur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.model.Skieur;
import tn.spring.springboot.repository.ISkieurRepository;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SkieurService implements ISkieurService{
    @Autowired
    private ISkieurRepository skieurRepository;
    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return skieurRepository.findAll();
    }

    @Override
    public Skieur addOrUpdateSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public void removeSkieur(Skieur skieur) {
        skieurRepository.delete(skieur);
    }

    @Override
    public Skieur retrieveSkieur(Long numSkieur) {
        return skieurRepository.findById(numSkieur)
                .orElseThrow(() -> new EntityNotFoundException("Skieur not found with id " + numSkieur));
    }
}
