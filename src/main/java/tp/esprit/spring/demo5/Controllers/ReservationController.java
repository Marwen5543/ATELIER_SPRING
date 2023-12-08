package tp.esprit.spring.demo5.Controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp.esprit.spring.demo5.Services.ReservationService;
import tp.esprit.spring.demo5.Services.UniversiteService;
import tp.esprit.spring.demo5.entity.Reservation;
import tp.esprit.spring.demo5.entity.Universite;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationService serv;
    @GetMapping("afficheR")
    public List<Reservation> findAll()
    {
        return serv.findAll();
    }

    @DeleteMapping("DeleteR")
    public String deleteReservation(@RequestParam("id") Long id) {
        serv.deleteReservation(id);
        return "Deleted Successfully";
    }

    @PutMapping("updateR/{id}")
    public String UpdateReservation(@PathVariable("id") Long id, @RequestBody Reservation reservation){
        reservation.setIdReservation(id); // Set the ID of the chambre object
        serv.UpdateReservation(reservation);
        return "Updated successfully";
    }

    @GetMapping("afficheR/{id}")
    public ResponseEntity<Reservation> findById(@PathVariable Long id) {
        Reservation reservation = (Reservation) serv.findById(id);
        if (reservation != null) {
            return ResponseEntity.ok(reservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("addR")
    public ResponseEntity<String> AddReservation(@RequestBody Reservation reservation) {
        log.info("add successful");
        serv.AddReservation(reservation);
        return ResponseEntity.ok("Ajouté avec succès");
    }
}
