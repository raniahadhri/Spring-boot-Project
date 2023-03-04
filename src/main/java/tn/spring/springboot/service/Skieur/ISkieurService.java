package tn.spring.springboot.service.Skieur;

import tn.spring.springboot.model.Skieur;
import java.util.List;
public interface ISkieurService {
    List<Skieur> retrieveAllSkieurs();

    Skieur addOrUpdateSkieur(Skieur skieur);

    void removeSkieur (Skieur skieur);

    Skieur retrieveSkieur (Long numSkieur);
    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);
}
