package tp.esprit.spring.demo5.Services;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.esprit.spring.demo5.Repositorys.BlocRepository;
import tp.esprit.spring.demo5.Repositorys.ChambreRepository;
import tp.esprit.spring.demo5.entity.Bloc;
import tp.esprit.spring.demo5.entity.Chambre;
import tp.esprit.spring.demo5.entity.Universite;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BlocService implements IBlocService {

    @Autowired
    private BlocRepository repo;
    @Autowired
    private ChambreRepository ChambreRepo;

    @Override
    public List<Bloc> findAll()
        {
            return (repo.findAll() != null)? repo.findAll() : null;
        }




    @Override
    public void deleteBloc(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void UpdateBloc(Bloc bloc) {
        repo.save(bloc);
    }

    @Override
    public List<Bloc> findById(Long id) {
        return (List<Bloc>) repo.findById(id).orElse(null);
    }

    @Override
    public void AddBloc(Bloc bloc) {
        repo.save(bloc);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = repo.findById(idBloc).orElse(null);
        List<Chambre> chambres = (List<Chambre>) ChambreRepo.findAllByNumChambreIn(numChambre);
        bloc.setChambres(new HashSet<>(chambres));
        repo.save(bloc);
        return bloc;
    }



}
