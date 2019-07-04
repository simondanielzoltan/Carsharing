package carsharing.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @SequenceGenerator(name = "subtaskItemSeqGenerator", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "subtaskItemSeqGenerator", strategy = GenerationType.SEQUENCE)
    @Column(name = "rent_id")
    private Long rentId;

    @Column(name = "transmission_time")
    private LocalDateTime transmissionDate;

    @Column(name = "rent_start_time")
    private LocalDate rentStartTime;


    @Column(name = "rent_end_time")
    private LocalDate rentEndTime;


    @ManyToOne
    @JoinColumn(name = "driver_id", foreignKey = @ForeignKey(name = "fk_driver_reservation"))
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "car_id", foreignKey = @ForeignKey(name = "fk_car_reservation"))
    private Car car;

    public Reservation(LocalDateTime transmission, LocalDate rentStartTime, LocalDate rentEndTime, Driver driver, Car car) {
        this.transmissionDate = transmission;
        this.rentStartTime = rentStartTime;
        this.rentEndTime = rentEndTime;
        this.driver = driver;
        this.car = car;
    }

    public Reservation() {
    }

    public Long getRentId() {
        return rentId;
    }

    public void setRentId(Long rentId) {
        this.rentId = rentId;
    }

    public LocalDateTime getTransmissionDate() {
        return transmissionDate;
    }

    public void setTransmissionDate(LocalDateTime transmissionDate) {
        this.transmissionDate = transmissionDate;
    }

    public LocalDate getRentStartTime() {
        return rentStartTime;
    }

    public void setRentStartTime(LocalDate rentStartTime) {
        this.rentStartTime = rentStartTime;
    }

    public LocalDate getRentEndTime() {
        return rentEndTime;
    }

    public void setRentEndTime(LocalDate rentEndTime) {
        this.rentEndTime = rentEndTime;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
