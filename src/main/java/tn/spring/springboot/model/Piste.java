package tn.spring.springboot.model;

import tn.spring.springboot.enums.Couleur;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Piste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numPiste;
    private String nomPiste;
    private Couleur couleur;
    private int longeur;
    private int pente;
}
