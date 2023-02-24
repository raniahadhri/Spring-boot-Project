package tn.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.model.Moniteur;
import java.util.List;
import tn.spring.springboot.service.Moniteur.IMoniteurService;

@RestController
@RequestMapping("/api/moniteur")
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

    @PostMapping()
    public Moniteur addMoniteur(@RequestBody Moniteur Moniteur) {
        return moniteurService.addOrUpdateMoniteur(Moniteur);
    }

    @DeleteMapping("/remove-Moniteur/{numMoniteur}")
    public void removeMoniteur(@PathVariable Moniteur Moniteur) {
        moniteurService.removeMoniteur(Moniteur);
    }

    @PutMapping("/modify-Moniteur")
    public Moniteur modifyMoniteur(@RequestBody Moniteur Moniteur) {
        return moniteurService.addOrUpdateMoniteur(Moniteur);
    }
}
