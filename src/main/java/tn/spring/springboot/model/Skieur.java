package tn.spring.springboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Skieur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numSkieur;
    private String nomS;
    private String prenomS;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private String ville;


    @OneToOne(cascade = CascadeType.ALL)
    private Abonnement abonnement;
    @ManyToMany
    private Set<Piste> pistes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="skieur")
    private Set<Inscription> inscriptions;
}
