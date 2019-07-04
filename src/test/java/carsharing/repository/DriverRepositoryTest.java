package carsharing.repository;

import carsharing.domain.Driver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DriverRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DriverRepository driverRepository;

    @Test
    public void whenFindByUsername_thenReturnDriver() {
        Driver driverShouldFound = new Driver("ferike", "123456", "Nagy Ferenc", LocalDate.of(2008, 1, 1));
        entityManager.persist(driverShouldFound);
        entityManager.flush();
        Optional<Driver> driverFound = driverRepository.findById(driverShouldFound.getLoginName());
        assertThat(driverFound.get().getLoginName()).isEqualTo(driverShouldFound.getLoginName());

    }
}
