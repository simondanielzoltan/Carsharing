package carsharing.service;

import carsharing.domain.Reservation;
import carsharing.repository.CarRepository;
import carsharing.repository.DriverRepository;
import carsharing.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private DriverRepository driverRepository;

    public Reservation save(Reservation reservation) {
        List<Reservation> reservations = reservationRepository.findByRentStartTimeBetween(reservation.getRentStartTime(), reservation.getRentEndTime());
        if (reservation.getCar().getTrafficTestDate().isBefore(reservation.getRentEndTime())
                && reservation.getDriver().getLisenceEndDate().isBefore(reservation.getRentEndTime())) {
            return null;
        }
        if (reservations.isEmpty()) {
            return reservationRepository.save(reservation);
        }
        return null;
    }

    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }

    public List<Reservation> listReservation() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).get();
    }

    public List<Reservation> getReservationsByDriver(String loginName) {
        return reservationRepository.findByDriver_LoginName(loginName);
    }

    public List<Reservation> getReservationsByCar(String plateNumber) {
        return reservationRepository.findByCar_PlateNumber(plateNumber);
    }

}