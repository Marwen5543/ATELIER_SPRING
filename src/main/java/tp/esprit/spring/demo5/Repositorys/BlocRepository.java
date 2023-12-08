package tp.esprit.spring.demo5.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tp.esprit.spring.demo5.entity.Bloc;
import tp.esprit.spring.demo5.entity.Universite;

@Repository
public interface BlocRepository extends JpaRepository <Bloc, Long>
{


}
