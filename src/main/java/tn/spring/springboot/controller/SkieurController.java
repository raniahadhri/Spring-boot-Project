package tn.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.model.Skieur;
import tn.spring.springboot.service.Skieur.ISkieurService;

import java.util.List;

@RestController
@RequestMapping("/api/skieur")
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

    @PostMapping()
    public Skieur addSkieur(@RequestBody Skieur Skieur) {
        return skieurService.addOrUpdateSkieur(Skieur);
    }

    @DeleteMapping("/remove-Skieur/{numSkieur}")
    public void removeSkieur(@PathVariable Skieur Skieur) {
        skieurService.removeSkieur(Skieur);
    }

    @PutMapping("/modify-Skieur")
    public Skieur modifySkieur(@RequestBody Skieur Skieur) {
        return skieurService.addOrUpdateSkieur(Skieur);
    }
}
