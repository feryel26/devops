package tn.esprit.spring_projet.entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"idEtudiant"})
@EqualsAndHashCode(exclude = {"idEtudiant"})
@FieldDefaults(level=AccessLevel.PRIVATE)
@Table(name = "Etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;
    private String nomEt;
    private String prenomEt;
    private long cin;
    private String ecole;
    private Date dateNaissance;
    private long capaciteFoyer;



}