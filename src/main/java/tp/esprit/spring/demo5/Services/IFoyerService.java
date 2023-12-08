package tp.esprit.spring.demo5.Services;

import tp.esprit.spring.demo5.entity.Foyer;
import tp.esprit.spring.demo5.entity.Universite;

import java.util.List;

public interface IFoyerService
{
    public List<Foyer> findAll();
    public void deleteFoyer(Long id);
    public void UpdateFoyer(Foyer foyer);
    public List<Foyer> findById (Long id);
    public void AddFoyer (Foyer foyer);

    public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite);
}
