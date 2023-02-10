package tn.spring.springboot.model;

import tn.spring.springboot.enums.TypeAbonnement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity

public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numAbon;
    private Date dateDebut;
    private Date dateFin;
    private float prixAbon;
    private TypeAbonnement typeAbon;
}
