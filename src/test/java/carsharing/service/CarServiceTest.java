package carsharing.service;

import carsharing.domain.Car;
import carsharing.repository.CarRepository;
import carsharing.repository.ReservationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class CarServiceTest {

    @TestConfiguration
    static class CarServiceTestContextConfiguration {
        @Bean
        public CarService carService() {
            return new CarService();
        }
    }

    @Autowired
    private CarService carService;

    @MockBean
    private CarRepository carRepository;

    @MockBean
    private ReservationRepository reservationRepository;

    @Before
    public void setup() {
        Car carShouldBeFound = new Car("CCC-003", "Audi", "A1", 2020, LocalDate.of(2010, 1, 20));
        Mockito.when(carRepository.findByBrand(carShouldBeFound.getBrand())).thenReturn(Arrays.asList(carShouldBeFound));
    }

    @Test
    public void whenValidBrand_thenCarListShouldBeFound() {
        String brand = "Audi";
        List<Car> found = carService.listCarsByBrand(brand);
        assertThat(found.get(0).getBrand())
                .isEqualTo(brand);
    }
}
