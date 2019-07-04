package carsharing.service;

import carsharing.domain.Driver;
import carsharing.repository.DriverRepository;
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
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class DriverServiceTest {

    @TestConfiguration
    static class DriverServiceTestContextConfiguration {
        @Bean
        public DriverService driverService() {
            return new DriverService();
        }
    }

    @Autowired
    private DriverService driverService;

    @MockBean
    private DriverRepository driverRepository;

    @MockBean
    private ReservationRepository reservationRepository;

    @Before
    public void setup() {
        Driver driverShouldBeFound = new Driver("ferike", "123456", "Nagy Ferenc", LocalDate.of(2008, 1, 1));
        Mockito.when(driverService.getDriverById(driverShouldBeFound.getLoginName())).thenReturn(Optional.of(driverShouldBeFound));
    }

    @Test
    public void whenValidID_thenReturnShouldBeFound() {
        String string = "ferike";
        Optional<Driver> driverFound = driverService.getDriverById(string);
        assertThat(driverFound.get().getLoginName()).isEqualTo(string);
    }

}
