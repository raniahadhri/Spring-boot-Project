package tn.spring.springboot.service.Abonnement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.model.Abonnement;
import tn.spring.springboot.repository.IAbonnementRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
public class AbonnementServiceImpl implements IAbonnementService {
    @Autowired
    private IAbonnementRepository AbonnementRepository;
    @Override
    public List<Abonnement> retrieveAllAbonnementes() {
        return AbonnementRepository.findAll();
    }

    @Override
    public Abonnement addOrUpdateAbonnement(Abonnement abonnement) {
        return AbonnementRepository.save(abonnement);
    }

    @Override
    public void removeAbonnement(Abonnement abonnement) {
        AbonnementRepository.delete(abonnement);
    }

    @Override
    public Abonnement retrieveAbonnement(Long numAbonnement) {
        return AbonnementRepository.findById(numAbonnement)
                .orElseThrow(() -> new EntityNotFoundException("Abonnement not found with id " + numAbonnement));
    }
}
