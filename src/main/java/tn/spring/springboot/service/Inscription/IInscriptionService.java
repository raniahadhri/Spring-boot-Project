package tn.spring.springboot.service.Inscription;

import tn.spring.springboot.model.Inscription;

import java.util.List;

public interface IInscriptionService {
    List<Inscription> retrieveAllInscriptions();
    Inscription addOrUpdateInscription(Inscription inscription);

    void removeInscription (Inscription inscription);

    Inscription retrieveInscription (Long numInscription);
}
