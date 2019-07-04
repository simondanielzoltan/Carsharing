package carsharing.repository;

import carsharing.domain.Reservation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReservationRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    public void whenFindByRentStartTimeBetween_thenReturnReservation() {
        Reservation reservation = new Reservation(LocalDateTime.now(), LocalDate.of(2018, 1, 1), LocalDate.of(2018, 1, 2), null, null);
        entityManager.persist(reservation);
        entityManager.flush();
        List<Reservation> reservationFound = reservationRepository.findByRentStartTimeBetween(LocalDate.of(2017, 12, 1), LocalDate.of(2019, 1, 1));
        assertThat(reservationFound.get(0)).isEqualTo(reservation);

    }

}
