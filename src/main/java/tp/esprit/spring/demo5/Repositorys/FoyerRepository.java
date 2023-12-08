package tp.esprit.spring.demo5.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tp.esprit.spring.demo5.entity.Foyer;
@Repository
public interface FoyerRepository extends JpaRepository<Foyer, Long>
{

}
