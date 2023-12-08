package tp.esprit.spring.demo5.Services;

import tp.esprit.spring.demo5.entity.Universite;

import java.util.List;

public interface IUniversiteService
{
    public List<Universite> findAll();
    public void deleteUniversite(Long id);
    public void UpdateUniversite(Universite universite);
    public List<Universite> findById (Long id);
    public void AddUniversite (Universite universite);

    Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite);
    Universite desaffecterFoyerAUniversite(long idUniversite);
}
