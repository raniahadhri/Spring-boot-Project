package tn.spring.springboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Inscription implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numInscription;
    private int numSemaine;

    @ManyToOne
    Skieur skieur;
    @ManyToOne
    Cours cours;

}
