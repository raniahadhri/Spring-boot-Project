package tn.spring.springboot.service.Skieur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.model.Piste;
import tn.spring.springboot.model.Skieur;
import tn.spring.springboot.repository.IAbonnementRepository;
import tn.spring.springboot.repository.IPisteRepository;
import tn.spring.springboot.repository.ISkieurRepository;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SkieurService implements ISkieurService{
    @Autowired
    private ISkieurRepository skieurRepository;
    @Autowired
    private IPisteRepository pisteRepository;
    @Autowired
    private IAbonnementRepository abonnementRepository;
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
        abonnementRepository.delete(skieur.getAbonnement());
        skieurRepository.delete(skieur);
    }

    @Override
    public Skieur retrieveSkieur(Long numSkieur) {
        return skieurRepository.findById(numSkieur)
                .orElseThrow(() -> new EntityNotFoundException("Skieur not found with id " + numSkieur));
    }

    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
        Piste piste = pisteRepository.findById(numPiste).orElseThrow(() -> new EntityNotFoundException("piste non trouvée"));
        Skieur skieur = skieurRepository.findById(numSkieur).orElseThrow(() -> new EntityNotFoundException("skieur non existant"));
        if(skieur!=null &&piste!=null) {
            skieur.getPistes().add(piste);
        }
        return skieurRepository.save(skieur);
    }
}
