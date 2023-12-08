package tp.esprit.spring.demo5.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.esprit.spring.demo5.Repositorys.BlocRepository;
import tp.esprit.spring.demo5.Repositorys.ChambreRepository;
import tp.esprit.spring.demo5.entity.Bloc;
import tp.esprit.spring.demo5.entity.Chambre;

import java.util.HashSet;
import java.util.List;

@Slf4j
@Service
public class ChambreService implements IChambreService
{
@Autowired
private ChambreRepository repo;
@Autowired
private BlocRepository repoB;


    @Override
    public List<Chambre> findAllChambre() {
        return (repo.findAll() != null)? (List<Chambre>) repo.findAll() : null;
    }

    @Override
    public void deleteChambre(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void UpdateChambre(Chambre chambre) {
        repo.save(chambre);
    }

    @Override
    public Chambre findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void AddChambre(Chambre chambre) {
        repo.save(chambre);
    }



}
