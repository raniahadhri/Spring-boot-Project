package tn.spring.springboot.service.Moniteur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.model.Moniteur;
import tn.spring.springboot.repository.IMoniteurRepository;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MoniteurServiceImpl implements IMoniteurService{
    @Autowired
    private IMoniteurRepository moniteurRepository;
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
}
