package tp.esprit.spring.demo5.Controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.esprit.spring.demo5.Services.FoyerService;
import tp.esprit.spring.demo5.entity.Foyer;
import tp.esprit.spring.demo5.entity.Universite;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/foyer")
public class FoyerController {

    @Autowired
    private FoyerService serv;

    @GetMapping("afficheF")
    public List<Foyer> findAll() {
        return serv.findAll();
    }

    @DeleteMapping("DeleteF")
    public String deleteFoyer(@RequestParam("id") Long id) {
        serv.deleteFoyer(id);
        return "Deleted Successfully";
    }

    @PutMapping("updateF/{id}")
    public String updateFoyer(@PathVariable("id") Long id, @RequestBody Foyer foyer) {
        foyer.setIdFoyer(id); // Set the ID of the chambre object
        serv.UpdateFoyer(foyer);
        return "Updated successfully";
    }

    @GetMapping("afficheF/{id}")
    public ResponseEntity<Foyer> findById(@PathVariable Long id) {
        Foyer foyer = (Foyer) serv.findById(id);
        if (foyer != null) {
            return ResponseEntity.ok(foyer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("addC")
    public ResponseEntity<String> addChambre(@RequestBody Foyer foyer) {
        log.info("add successful");
        serv.AddFoyer(foyer);
        return ResponseEntity.ok("Ajouté avec succès");
    }


    @PostMapping("/ajouter-affecter")
    public void ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @RequestParam("idUniveriste") long idUniversite) {
        serv.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }




}
