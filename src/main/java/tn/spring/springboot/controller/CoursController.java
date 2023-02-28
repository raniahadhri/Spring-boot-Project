package tn.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.model.Cours;
import tn.spring.springboot.service.Cours.ICoursService;
import java.util.List;

@RestController
@RequestMapping("/cours")
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

    @PostMapping
    public Cours addCours(@RequestBody Cours cours) {
        return coursService.addOrUpdateCours(cours);
    }

    @DeleteMapping("/{numCours}")
    public void removeCours(@PathVariable Long numCours) {
        Cours cours = coursService.retrieveCours(numCours);
        if (cours != null) {
            coursService.removeCours(cours);
        }
    }

    @PutMapping("/{numCours}")
    public Cours updateCours(@PathVariable Long numCours, @RequestBody Cours cours) {
        cours.setNumCours(numCours);
        return coursService.addOrUpdateCours(cours);
    }
}
