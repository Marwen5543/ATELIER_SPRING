package tp.esprit.spring.demo5.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tp.esprit.spring.demo5.entity.Foyer;
import tp.esprit.spring.demo5.entity.Universite;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite,Long>
{
    Universite findUniversiteByNomUniversite(String nomUniversite);
    Universite findByIdUniversite(long id);
}
