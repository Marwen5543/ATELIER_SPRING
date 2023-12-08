package tp.esprit.spring.demo5.Services;

import tp.esprit.spring.demo5.entity.Bloc;
import tp.esprit.spring.demo5.entity.Chambre;

import java.util.List;

public interface IBlocService
{
    public List<Bloc> findAll();
    public void deleteBloc(Long id);
    public void UpdateBloc(Bloc bloc);
    public List<Bloc> findById (Long id);
    public void AddBloc (Bloc bloc);

    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) ;

}
