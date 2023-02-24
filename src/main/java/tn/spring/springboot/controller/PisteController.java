package tn.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.model.Piste;
import tn.spring.springboot.service.Piste.IPisteService;

import java.util.List;

@RestController
@RequestMapping("/api/piste")

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

    @PostMapping()
    public Piste addPiste(@RequestBody Piste Piste) {
        return pisteService.addOrUpdatePiste(Piste);
    }

    @DeleteMapping("/remove-Piste/{numPiste}")
    public void removePiste(@PathVariable Piste Piste) {
        pisteService.removePiste(Piste);
    }

    @PutMapping("/modify-Piste")
    public Piste modifyPiste(@RequestBody Piste Piste) {
        return pisteService.addOrUpdatePiste(Piste);
    }

}
