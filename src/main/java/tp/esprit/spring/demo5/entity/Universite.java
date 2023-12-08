package tp.esprit.spring.demo5.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@Entity

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    long idUniversite;
    String nomUniversite;
    String adresse;

@JsonIgnore
   @OneToOne (mappedBy = "universite")
   private Foyer foyer;


    public void setFoyer(Foyer foyer) {
        this.foyer = foyer;
    }
}
