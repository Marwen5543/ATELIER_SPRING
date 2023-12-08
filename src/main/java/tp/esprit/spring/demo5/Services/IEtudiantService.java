package tp.esprit.spring.demo5.Services;

import tp.esprit.spring.demo5.entity.Etudiant;

import java.util.List;

public interface IEtudiantService {
    public List<Etudiant> findAll();
    public void deleteEtudiant(Long id);
    public void UpdateEtudiant(Etudiant etudiant);
    public Etudiant findById (Long id);
    public void AddEtudiant (Etudiant etudiant);

}
