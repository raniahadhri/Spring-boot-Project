package tn.spring.springboot.service.Piste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.model.Piste;
import tn.spring.springboot.repository.IPisteRepository;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PisteService implements IPisteService{
    @Autowired
    private IPisteRepository pisteRepository;
    @Override
    public List<Piste> retrieveAllPistes() {
        return pisteRepository.findAll();
    }

    @Override
    public Piste addOrUpdatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public void removePiste(Piste piste) {
        pisteRepository.delete(piste);
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste)
                .orElseThrow(() -> new EntityNotFoundException("Piste not found with id " + numPiste));
    }
}
