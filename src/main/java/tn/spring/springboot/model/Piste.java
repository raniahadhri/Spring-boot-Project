package tn.spring.springboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.spring.springboot.enums.Couleur;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Piste implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numPiste;
    private String nomPiste;
    private Couleur couleur;
    private int longeur;
    private int pente;
    //,cascade = CascadeType.ALL
    @ManyToMany(mappedBy="pistes")
    private Set<Skieur> skieurs;
}
