package carsharing.util;

import carsharing.domain.Car;
import carsharing.domain.Driver;
import carsharing.domain.Reservation;
import carsharing.repository.CarRepository;
import carsharing.repository.DriverRepository;
import carsharing.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public void run(String... args) throws Exception {

        Car car1 = new Car("AAA-001", "Audi", "A1", 2010, LocalDate.of(2011, 11, 20));
        Car car2 = new Car("BBB-001", "Mercedes", "M1", 2011, LocalDate.of(2020, 1, 21));

        Driver driver1 = new Driver("ferike", "123456", "Nagy Ferenc", LocalDate.of(2008, 1, 1));
        Driver driver2 = new Driver("katika", "123456", "Nagy Kata", LocalDate.of(2006, 2, 1));

        Reservation reservation1 = new Reservation(LocalDateTime.now(), LocalDate.of(2018, 1, 1), LocalDate.of(2018, 1, 2), driver1, car1);
        Reservation reservation2 = new Reservation(LocalDateTime.now(), LocalDate.of(2018, 1, 2), LocalDate.of(2018, 1, 5), driver2, car2);

        carRepository.save(car1);
        carRepository.save(car2);

        driverRepository.save(driver1);
        driverRepository.save(driver2);

        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);


    }
}
