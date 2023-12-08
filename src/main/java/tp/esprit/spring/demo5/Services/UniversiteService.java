package tp.esprit.spring.demo5.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.esprit.spring.demo5.Repositorys.FoyerRepository;
import tp.esprit.spring.demo5.Repositorys.UniversiteRepository;
import tp.esprit.spring.demo5.entity.Foyer;
import tp.esprit.spring.demo5.entity.Universite;

import java.util.List;

@Slf4j
@Service
public class UniversiteService implements IUniversiteService{

    @Autowired
    private UniversiteRepository repo;
    @Autowired
    private FoyerRepository foyerRepo;
    @Override
    public List<Universite> findAll() {
        return (repo.findAll() != null)? repo.findAll() : null;
    }

    @Override
    public void deleteUniversite(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void UpdateUniversite(Universite universite) {
        repo.save(universite);
    }

    @Override
    public List<Universite> findById(Long id) {
        return (List<Universite>) repo.findById(id).orElse(null);
    }

    @Override
    public void AddUniversite(Universite universite) {
        repo.save(universite);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Universite u = repo.findUniversiteByNomUniversite(nomUniversite);
        u.setFoyer(foyerRepo.findById(idFoyer).orElse(null));
        return repo.save(u);
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite u = repo.findById(idUniversite).orElse(null);
        u.setFoyer(null);
        return repo.save(u);
    }
}
