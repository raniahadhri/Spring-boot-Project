package tn.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.model.Inscription;
import tn.spring.springboot.service.Inscription.IInscriptionService;

import java.util.List;

@RestController
@RequestMapping("/inscription")
public class InscriptionController {
    @Autowired
    private IInscriptionService InscriptionService;

    @GetMapping
    public List<Inscription> retrieveAllInscriptions() {
        return InscriptionService.retrieveAllInscriptions();
    }

    @GetMapping("/{numInscription}")
    public Inscription retrieveInscription(@PathVariable Long numInscription) {
        return InscriptionService.retrieveInscription(numInscription);
    }

    @PostMapping
    public Inscription addInscription(@RequestBody Inscription inscription) {
        return InscriptionService.addOrUpdateInscription(inscription);
    }

    @DeleteMapping("/{numInscription}")
    public void removeInscription(@PathVariable Long numInscription) {
        Inscription inscription = InscriptionService.retrieveInscription(numInscription);
        if (inscription != null) {
            InscriptionService.removeInscription(inscription);
        }
    }

    @PutMapping("/{numInscription}")
    public Inscription updateInscription(@PathVariable Long numInscription, @RequestBody Inscription inscription) {
        inscription.setNumInscription(numInscription);
        return InscriptionService.addOrUpdateInscription(inscription);
    }
}
