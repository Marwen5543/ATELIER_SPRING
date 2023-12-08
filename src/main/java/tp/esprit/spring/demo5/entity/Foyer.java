package tp.esprit.spring.demo5.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.Set;

@Entity
@Data
public class Foyer {


        @Id
        @Generated
        private long idFoyer;
        private String nomFoyer;
        private long capaciteFoyer;
        @OneToOne
        private Universite universite;
       @OneToMany (cascade = CascadeType.ALL ,mappedBy = "foyer")
        private Set<Bloc> Blocs;

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }
}

