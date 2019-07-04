package carsharing.repository;

import carsharing.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, String> {

    public void deleteById(String id);

    public List<Car> findByBrand(String brand);

    public List<Car> findByType(String type);

    public List<Car> findByTrafficTestDateAfter(LocalDate localDate);


}
