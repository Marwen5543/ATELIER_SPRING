package tp.esprit.spring.demo5.Services;

import tp.esprit.spring.demo5.entity.Bloc;
import tp.esprit.spring.demo5.entity.Chambre;

import java.util.List;

public interface IChambreService {

    public List<Chambre> findAllChambre();
    public void deleteChambre(Long id);
    public void UpdateChambre(Chambre chambre);
    public Chambre findById (Long id);
    public void AddChambre (Chambre chambre);


}
