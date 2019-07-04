package carsharing.service;

import carsharing.domain.Driver;
import carsharing.domain.Reservation;
import carsharing.repository.DriverRepository;
import carsharing.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public Driver save(Driver driver) {
        return driverRepository.save(driver);
    }

    public void delete(String id) {
        for (int i = 0; i < reservationRepository.findAll().size(); i++) {
            Reservation chosenReservation = reservationRepository.findAll().get(i);
            if (chosenReservation.getDriver().getFullname() == id) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            driverRepository.deleteById(id);
        }
    }

    public List<Driver> listDrivers() {
        return driverRepository.findAll();
    }

    public Optional<Driver> getDriverById(String id) {
        return driverRepository.findById(id);
    }


}
