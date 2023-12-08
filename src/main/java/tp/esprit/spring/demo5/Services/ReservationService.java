package tp.esprit.spring.demo5.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.esprit.spring.demo5.Repositorys.ReservationRepository;
import tp.esprit.spring.demo5.entity.Foyer;
import tp.esprit.spring.demo5.entity.Reservation;

import java.util.List;

@Slf4j
@Service
public class ReservationService implements IReservationService{

    @Autowired
    private ReservationRepository repo;
    @Override
    public List<Reservation> findAll() {
        return (repo.findAll() != null)? (List<Reservation>) repo.findAll() : null;
    }

    @Override
    public void deleteReservation(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void UpdateReservation(Reservation reservation) {
        repo.save(reservation);
    }

    @Override
    public List<Reservation> findById(Long id) {
        return (List<Reservation>) repo.findById(id).orElse(null);
    }

    @Override
    public void AddReservation(Reservation reservation) {
        repo.save(reservation);
    }
}
