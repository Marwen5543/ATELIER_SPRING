package tp.esprit.spring.demo5.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties("reservations")
public class Chambre implements Serializable {
    @Id
    private Long idChambre;
    private Long numeroChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;
    private Long numChambre;



    @ManyToOne
    Bloc bloc;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chambre")
    private Set<Reservation> reservations;

    public Long getNumChambre() {
        return numChambre;
    }

    public void setNumChambre(Long numChambre) {
        this.numChambre = numChambre;
    }
}
