package tp.esprit.spring.demo5.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idEtudiant ;
    private String nomEt;
    private String PrenomEt;
    private long cin;
    private String ecole;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @ManyToMany(mappedBy="etudiants", cascade = CascadeType.ALL)

    private Set<Reservation> reservations;
}
