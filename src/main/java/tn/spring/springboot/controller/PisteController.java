package tn.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.model.Piste;
import tn.spring.springboot.service.Piste.IPisteService;

import java.util.List;

@RestController
@RequestMapping("/piste")

public class PisteController {
    @Autowired
    private IPisteService pisteService;

    @GetMapping
    public List<Piste> retrieveAllPistees() {
        return pisteService.retrieveAllPistes();
    }

    @GetMapping("/{numPiste}")
    public Piste retrievePiste(@PathVariable Long numPiste) {
        return pisteService.retrievePiste(numPiste);
    }

    @PostMapping
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteService.addOrUpdatePiste(piste);
    }

    @DeleteMapping("/{numPiste}")
    public void removePiste(@PathVariable Long numPiste) {
        Piste piste = pisteService.retrievePiste(numPiste);
        if(piste != null) {
            pisteService.removePiste(piste);
        }
    }

    @PutMapping("/{numPiste}")
    public Piste modifyPiste(@PathVariable Long numPiste, @RequestBody Piste piste) {
        piste.setNumPiste(numPiste);
        return pisteService.addOrUpdatePiste(piste);
    }

}
