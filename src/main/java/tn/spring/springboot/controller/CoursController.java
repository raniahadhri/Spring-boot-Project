package tn.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.model.Cours;
import tn.spring.springboot.service.Cours.ICoursService;
import java.util.List;

@RestController
@RequestMapping("/api/cours")
public class CoursController {
    @Autowired
    private ICoursService coursService;

    @GetMapping
    public List<Cours> retrieveAllCourses() {
        return coursService.retrieveAllCourses();
    }

    @GetMapping("/{numCours}")
    public Cours retrieveCours(@PathVariable Long numCours) {
        return coursService.retrieveCours(numCours);
    }

    @PostMapping()
    public Cours addCours(@RequestBody Cours cours) {
        return coursService.addOrUpdateCours(cours);
    }

    @DeleteMapping("/remove-cours/{numCours}")
    public void removeCours(@PathVariable Cours cours) {
        coursService.removeCours(cours);
    }

    @PutMapping("/modify-cours")
    public Cours modifyCours(@RequestBody Cours cours) {
        return coursService.addOrUpdateCours(cours);
    }
}
