package tp.esprit.spring.demo5.entity;

import com.fasterxml.jackson.annotation.*;
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
@JsonIgnoreProperties("chambre")
public class Reservation implements Serializable {
    @Id
    @Generated
    private long idReservation;
    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire;
    private boolean estValide;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;

    @ManyToOne
    private Chambre chambre;

}
