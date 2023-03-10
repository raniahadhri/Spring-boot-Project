package tn.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.enums.TypeAbonnement;
import tn.spring.springboot.model.Skieur;
import tn.spring.springboot.service.Abonnement.IAbonnementService;
import tn.spring.springboot.service.Skieur.ISkieurService;

import java.util.List;

@RestController
@RequestMapping("/skieur")
public class SkieurController {

    @Autowired
    private ISkieurService skieurService;

    @GetMapping
    public List<Skieur> retrieveAllSkieures() {
        return skieurService.retrieveAllSkieurs();
    }

    @GetMapping("/{numSkieur}")
    public Skieur retrieveSkieur(@PathVariable Long numSkieur) {
        return skieurService.retrieveSkieur(numSkieur);
    }

    @PostMapping
    public Skieur addSkieur(@RequestBody Skieur skieur) {
        return skieurService.addOrUpdateSkieur(skieur);
    }
    @PostMapping("add/{numSkieur}/{numPiste}")
    public Skieur assignSkierToPiste(@PathVariable long numSkieur,@PathVariable long numPiste) {
        return skieurService.assignSkierToPiste(numSkieur,numPiste);
    }

    @DeleteMapping("/{numSkieur}")
    public void removeSkieur(@PathVariable long numSkieur) {
        Skieur skieur= skieurService.retrieveSkieur(numSkieur);
        if(skieur!= null) {
            skieurService.removeSkieur(skieur);
        }
    }

    @PutMapping("/{numSkieur}")
    public Skieur modifySkieur(@PathVariable long numSkieur,@RequestBody Skieur skieur) {
        skieur.setNumSkieur(numSkieur);
        return skieurService.addOrUpdateSkieur(skieur);
    }

    @GetMapping("/retrieve/{typeAbonnement}")
    public List<Skieur> retrieveSkiersBySubscriptionType(@PathVariable TypeAbonnement typeAbonnement){
        return skieurService.retrieveSkiersBySubscriptionType(typeAbonnement);
    }
}
