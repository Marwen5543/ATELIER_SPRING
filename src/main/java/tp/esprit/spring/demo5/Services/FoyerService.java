package tp.esprit.spring.demo5.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tp.esprit.spring.demo5.Repositorys.FoyerRepository;
import tp.esprit.spring.demo5.Repositorys.UniversiteRepository;
import tp.esprit.spring.demo5.entity.Foyer;
import tp.esprit.spring.demo5.entity.Universite;

import java.util.List;

@Slf4j
@Service
@Repository
public class FoyerService implements  IFoyerService {

    @Autowired
    private FoyerRepository repo;
    private UniversiteRepository univ;

    @Override
    public List<Foyer> findAll() {
        return (repo.findAll() != null) ? repo.findAll() : null;
    }

    @Override
    public void deleteFoyer(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void UpdateFoyer(Foyer foyer) {
        repo.save(foyer);
    }

    @Override
    public List<Foyer> findById(Long id) {
        return (List<Foyer>) repo.findById(id).orElse(null);
    }

    @Override
    public void AddFoyer(Foyer foyer) {
        repo.save(foyer);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Foyer foyer1 = repo.save(foyer);
        Universite universite = univ.findByIdUniversite(idUniversite);
        universite.setFoyer(foyer1);
       // foyer1.setUniversite(universite);
        univ.save(universite);
        return foyer1;
    }


}
    