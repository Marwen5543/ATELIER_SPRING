package tp.esprit.spring.demo5.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tp.esprit.spring.demo5.Services.EtudiantService;
import tp.esprit.spring.demo5.entity.Etudiant;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
    @Autowired
    private EtudiantService serv;
    @GetMapping("")
    @Scheduled(fixedDelay = 60000)
    @Scheduled(cron ="*/60 * * * * *")
    public List<Etudiant> findAllEtudiant() {
        log.info("every 60 sec");
        return serv.findAll();
    }

    @GetMapping("/{id}")
    public Etudiant findArticleById(@PathVariable Integer id) {
        return serv.findById(Long.valueOf(id));
    }




    @PostMapping("")
    public String AddEtudiant(@RequestBody Etudiant etudiant) {
        try {

            log.info("add successful");
                serv.AddEtudiant(etudiant);
                return "Ajouter avec sucsses";


        } catch (Exception e) {
            // Handle the exception here
            // For example, you could log the exception and return a generic error message to the user
            e.printStackTrace();
            return "An error occurred while adding the student";
        }
    }


    @PutMapping("")
    public String updateEtudiant(@RequestBody Etudiant etudiant) {
        serv.UpdateEtudiant(etudiant);
        return "updated sucssefully";
    }

    @DeleteMapping("/{id}")
    public String deleteArticle(@PathVariable Integer id) {
        serv.deleteEtudiant(Long.valueOf(id));
        return "Deleted Sucssefully";
    }

}
