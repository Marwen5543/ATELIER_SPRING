package tp.esprit.spring.demo5.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.esprit.spring.demo5.Repositorys.EtudiantRepository;
import tp.esprit.spring.demo5.entity.Etudiant;

import java.util.List;

@Slf4j
@Service
public class EtudiantService implements  IEtudiantService
{
    @Autowired
    private EtudiantRepository repo;

    @Override
    public List<Etudiant> findAll() {
        return (repo.findAll() != null)? repo.findAll() : null;
    }

    @Override
    public void deleteEtudiant(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void UpdateEtudiant(Etudiant etudiant) {
        repo.save(etudiant);
    }

    @Override
    public Etudiant findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void AddEtudiant(Etudiant etudiant) {
        repo.save(etudiant);
    }
}
