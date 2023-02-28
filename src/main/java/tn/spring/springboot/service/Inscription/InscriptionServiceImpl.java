package tn.spring.springboot.service.Inscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.model.Inscription;
import tn.spring.springboot.repository.IInscriptionRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
public class InscriptionServiceImpl implements IInscriptionService {
    @Autowired
    private IInscriptionRepository InscriptionRepository;
    @Override
    public List<Inscription> retrieveAllInscriptions() {
        return InscriptionRepository.findAll();
    }

    @Override
    public Inscription addOrUpdateInscription(Inscription inscription) {
        return InscriptionRepository.save(inscription);
    }

    @Override
    public void removeInscription(Inscription inscription) {
        InscriptionRepository.delete(inscription);
    }

    @Override
    public Inscription retrieveInscription(Long numInscription) {
        return InscriptionRepository.findById(numInscription)
                .orElseThrow(() -> new EntityNotFoundException("Inscription not found with id " + numInscription));
    }
}
