package carsharing.service;

import carsharing.domain.Car;
import
        carsharing.domain.Reservation;
import carsharing.repository.CarRepository;
import carsharing.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    ReservationRepository reservationRepository;

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public void delete(String id) {
        for (int i = 0; i < reservationRepository.findAll().size(); i++) {
            Reservation chosenReservation = reservationRepository.findAll().get(i);
            if (chosenReservation.getCar().getPlateNumber().equals(id)) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            carRepository.deleteById(id);
        }

    }

    public List<Car> listCars() {
        return carRepository.findAll();
    }

    public Car getCarById(String id) {
        return carRepository.findById(id).get();
    }

    public List<Car> listCarsByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

    public List<Car> listCarsByType(String type) {
        return carRepository.findByType(type);
    }

    public List<Car> listCarsByValidLisence() {
        return carRepository.findByTrafficTestDateAfter(LocalDate.now());
    }


}
