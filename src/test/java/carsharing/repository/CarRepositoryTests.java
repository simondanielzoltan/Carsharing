package carsharing.repository;

import carsharing.domain.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CarRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void whenFindByBrand_thenReturnCar() {
        Car carShouldBeFound = new Car("CCC-003", "Audi", "A1", 2020, LocalDate.of(2010, 1, 20));
        entityManager.persist(carShouldBeFound);
        entityManager.flush();
        List<Car> carFound = carRepository.findByBrand(carShouldBeFound.getBrand());
        assertThat(carFound.get(0).getBrand()).isEqualTo(carShouldBeFound.getBrand());
    }

}
