package tn.spring.springboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.spring.springboot.enums.Support;
import tn.spring.springboot.enums.TypeCours;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Cours implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numCours;
    private int niveau;
    private TypeCours typeCours;
    private Support support;
    private float prix;
    private int creneau;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="cours")
    private Set<Inscription> inscriptions;
}
