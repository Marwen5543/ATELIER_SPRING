package tp.esprit.spring.demo5.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.esprit.spring.demo5.Services.ChambreService;
import tp.esprit.spring.demo5.Services.UniversiteService;
import tp.esprit.spring.demo5.entity.Chambre;
import tp.esprit.spring.demo5.entity.Universite;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/universite")
public class UniversiteController {



        @Autowired
        private UniversiteService serv;
        @GetMapping("afficheU")
        public List<Universite> findAll()
        {
            return serv.findAll();
        }

        @DeleteMapping("DeleteU")
        public String deleteChambre(@RequestParam("id") Long id) {
            serv.deleteUniversite(id);
            return "Deleted Successfully";
        }

        @PutMapping("updateU/{id}")
        public String UpdateUniversite(@PathVariable("id") Long id, @RequestBody Universite universite){
            universite.setIdUniversite(id); // Set the ID of the chambre object
            serv.UpdateUniversite(universite);
            return "Updated successfully";
        }

        @GetMapping("afficheU/{id}")
        public ResponseEntity<Universite> findById(@PathVariable Long id) {
            Universite universite = (Universite) serv.findById(id);
            if (universite != null) {
                return ResponseEntity.ok(universite);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping("addU")
        public ResponseEntity<String> AddUniversite(@RequestBody Universite universite) {
            log.info("add successful");
            serv.AddUniversite(universite);
            return ResponseEntity.ok("Ajouté avec succès");
        }

    @PutMapping("/affecterFoyer/{nomUniversite}/{idFoyer}")
    public Universite affecterFoyerAUniversite(@PathVariable long idFoyer,@PathVariable String nomUniversite){
        return serv.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }

    @PutMapping("/desaffecterFoyer/{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable long idUniversite){
        return serv.desaffecterFoyerAUniversite(idUniversite);
    }



    }
