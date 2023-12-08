package tp.esprit.spring.demo5.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tp.esprit.spring.demo5.entity.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long>
{

}
