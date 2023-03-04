package tn.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.model.Moniteur;
import java.util.List;
import tn.spring.springboot.service.Moniteur.IMoniteurService;

@RestController
@RequestMapping("/moniteur")
public class MoniteurController {
    @Autowired
    private IMoniteurService moniteurService;

    @GetMapping
    public List<Moniteur> retrieveAllMoniteures() {
        return moniteurService.retrieveAllMoniteurs();
    }

    @GetMapping("/{numMoniteur}")
    public Moniteur retrieveMoniteur(@PathVariable Long numMoniteur) {
        return moniteurService.retrieveMoniteur(numMoniteur);
    }

    @PostMapping
    public Moniteur addMoniteur(@RequestBody Moniteur moniteur) {
        return moniteurService.addOrUpdateMoniteur(moniteur);
    }

    @PostMapping("/add/{numCours}")
    public Moniteur addInstructorAndAssignToCourse( @RequestBody Moniteur moniteur,@PathVariable Long numCours) {
        return moniteurService.addInstructorAndAssignToCourse(moniteur,numCours);
    }

    @DeleteMapping("/{numMoniteur}")
    public void removeMoniteur(@PathVariable Long numMoniteur) {
        Moniteur moniteur = moniteurService.retrieveMoniteur(numMoniteur);
        if(moniteur!=null) {
            moniteurService.removeMoniteur(moniteur);
        }
    }

    @PutMapping("/{numMoniteur}")
    public Moniteur modifyMoniteur(@PathVariable Long numMoniteur, @RequestBody Moniteur moniteur) {
        moniteur.setNumMoniteur(numMoniteur);
            return moniteurService.addOrUpdateMoniteur(moniteur);
    }
}
