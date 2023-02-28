package tn.spring.springboot.service.Abonnement;

import tn.spring.springboot.model.Abonnement;

import java.util.List;

public interface IAbonnementService {
    List<Abonnement> retrieveAllAbonnementes();
    Abonnement addOrUpdateAbonnement(Abonnement abonnement);

    void removeAbonnement (Abonnement abonnement);

    Abonnement retrieveAbonnement (Long numAbonnement);
}
