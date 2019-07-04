package carsharing.repository;

import carsharing.domain.Car;
import carsharing.domain.Driver;
import carsharing.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    public void deleteById(Long id);

    public List<Reservation> findByCar(Car car);

    public List<Reservation> findByDriver_LoginName(String loginName);

    public List<Reservation> findByCar_PlateNumber(String plateNumber);

    public List<Reservation> findByRentStartTimeBetween(LocalDate rentStartTime, LocalDate rentEndTime);

}
