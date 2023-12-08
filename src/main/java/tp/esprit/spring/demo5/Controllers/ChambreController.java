package tp.esprit.spring.demo5.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.esprit.spring.demo5.Services.ChambreService;
import tp.esprit.spring.demo5.entity.Bloc;
import tp.esprit.spring.demo5.entity.Chambre;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/chambre")
public class ChambreController {
    @Autowired
    private ChambreService serv;
    @GetMapping("afficheC")
    public List<Chambre> findAllChambre()
    {
        return serv.findAllChambre();
    }

    @DeleteMapping("DeleteC")
    public String deleteChambre(@RequestParam("id") Long id) {
        serv.deleteChambre(id);
        return "Deleted Successfully";
    }

    @PutMapping("updateC/{id}")
    public String updateChambre(@PathVariable("id") Long id, @RequestBody Chambre chambre){
        chambre.setIdChambre(id); // Set the ID of the chambre object
        serv.UpdateChambre(chambre);
        return "Updated successfully";
    }

    @GetMapping("afficheC/{id}")
    public ResponseEntity<Chambre> findById(@PathVariable Long id) {
        Chambre chambre = serv.findById(id);
        if (chambre != null) {
            return ResponseEntity.ok(chambre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("addC")
    public ResponseEntity<String> addChambre(@RequestBody Chambre chambre) {
        log.info("add successful");
        serv.AddChambre(chambre);

        return ResponseEntity.ok("Ajouté avec succès");

    }




}
