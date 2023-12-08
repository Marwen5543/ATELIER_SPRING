package tp.esprit.spring.demo5.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.esprit.spring.demo5.Services.BlocService;
import tp.esprit.spring.demo5.entity.Bloc;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/bloc")
public class BlocController {
    @Autowired
    private BlocService serv;
    @GetMapping("afficheB")
    public List<Bloc> findAll()
    {
        return serv.findAll();
    }

    @DeleteMapping("DeleteB")
    public String deleteBloc(@RequestParam("id") Long id) {
        serv.deleteBloc(id);
        return "Deleted Successfully";
    }

    @PutMapping("updateB/{id}")
    public String updateBloc(@PathVariable("id") Long id, @RequestBody Bloc bloc){
        bloc.setIdBloc(id); // Set the ID of the chambre object
        serv.UpdateBloc(bloc);
        return "Updated successfully";
    }

    @GetMapping("/afficheB/{id}")
    public ResponseEntity<Bloc> findById(@PathVariable Long id) {
        List<Bloc> bloc = serv.findById(id);
        if (bloc != null) {
            return ResponseEntity.ok((Bloc) bloc);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("addC")
    public ResponseEntity<String> AddBloc(@RequestBody Bloc bloc) {
        log.info("Add successful");
        serv.AddBloc(bloc);
        return ResponseEntity.ok("Ajouté avec succès");
    }

    @PutMapping("/affecterBloc/{idBloc}/{numChambre}")
    public Bloc affecterChambresABloc(@PathVariable long numBloc, @PathVariable List<Long> numChambre) {
        return serv.affecterChambresABloc(numChambre, numBloc);
    }
}
