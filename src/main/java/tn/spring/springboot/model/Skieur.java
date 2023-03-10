package tn.spring.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    public Skieur(Long numSkieur){
        this.numSkieur=numSkieur;
    }
    @OneToOne(cascade = CascadeType.ALL)
    private Abonnement abonnement;
    @ManyToMany
//    @JsonIgnore
    @JoinTable(
            name = "skieur_pistes",
            joinColumns = @JoinColumn(name = "num_skieur"),
            inverseJoinColumns = @JoinColumn(name = "num_piste"))
    private Set<Piste> pistes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="skieur")
    private Set<Inscription> inscriptions;
}
