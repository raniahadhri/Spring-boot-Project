package tn.spring.springboot.service.Abonnement;

import tn.spring.springboot.model.Abonnement;

import java.time.LocalDate;
import java.util.List;

public interface IAbonnementService {
    List<Abonnement> retrieveAllAbonnementes();
    Abonnement addOrUpdateAbonnement(Abonnement abonnement);

    void removeAbonnement (Abonnement abonnement);

    Abonnement retrieveAbonnement (Long numAbonnement);
    List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);
}
