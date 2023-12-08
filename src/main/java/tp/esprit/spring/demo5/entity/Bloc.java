package tp.esprit.spring.demo5.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idBloc;
    String nomBloc;
    long capaciteBloc;
    @JsonIgnore
    @ManyToOne
    Foyer foyer;
    @JsonIgnore
    @OneToMany
    (cascade = CascadeType.ALL, mappedBy="bloc")
    private Set<Chambre> Chambres;
}
