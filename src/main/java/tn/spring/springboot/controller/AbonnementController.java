package tn.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.model.Abonnement;
import tn.spring.springboot.service.Abonnement.IAbonnementService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/abonnement")
public class AbonnementController {
    @Autowired
    private IAbonnementService AbonnementService;

    @GetMapping
    public List<Abonnement> retrieveAllAbonnementes() {
        return AbonnementService.retrieveAllAbonnementes();
    }

    @GetMapping("/{numAbonnement}")
    public Abonnement retrieveAbonnement(@PathVariable Long numAbonnement) {
        return AbonnementService.retrieveAbonnement(numAbonnement);
    }

    @PostMapping
    public Abonnement addAbonnement(@RequestBody Abonnement abonnement) {
        return AbonnementService.addOrUpdateAbonnement(abonnement);
    }

    @DeleteMapping("/{numAbonnement}")
    public void removeAbonnement(@PathVariable Long numAbonnement) {
        Abonnement abonnement = AbonnementService.retrieveAbonnement(numAbonnement);
        if (abonnement != null) {
            AbonnementService.removeAbonnement(abonnement);
        }
    }

    @PutMapping("/{numAbonnement}")
    public Abonnement updateAbonnement(@PathVariable Long numAbonnement, @RequestBody Abonnement abonnement) {
        abonnement.setNumAbon(numAbonnement);
        return AbonnementService.addOrUpdateAbonnement(abonnement);
    }
//    @GetMapping("/entre/{startDate}/{endDate}")
//    List<Abonnement> retrieveSubscriptionsByDates(@PathVariable LocalDate startDate, @PathVariable LocalDate endDate){
//        return AbonnementService.retrieveSubscriptionsByDates(startDate,endDate);
//    }
}
