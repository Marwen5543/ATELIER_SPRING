package tp.esprit.spring.demo5.Services;

import tp.esprit.spring.demo5.entity.Reservation;

import java.util.List;

public interface IReservationService
{
    public List<Reservation> findAll();
    public void deleteReservation(Long id);
    public void UpdateReservation(Reservation reservation);
    public List<Reservation> findById (Long id);
    public void AddReservation (Reservation reservation);


}
