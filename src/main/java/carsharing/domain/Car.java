package carsharing.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @Column(name = "plate_number")
    private String plateNumber;

    @Column(name = "brand")
    private String brand;

    @Column(name = "type")
    private String type;

    @Column(name = "vintage")
    private int vintage;

    @Column(name = "traffic_test_date")
    private LocalDate trafficTestDate;

    @OneToMany(mappedBy = "car")
    private List<Reservation> reservations;

    public Car() {
    }

    public Car(String plateNumber, String brand, String type, int vintage, LocalDate trafficTestDate) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.type = type;
        this.vintage = vintage;
        this.trafficTestDate = trafficTestDate;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVintage() {
        return vintage;
    }

    public void setVintage(int vintage) {
        this.vintage = vintage;
    }

    public LocalDate getTrafficTestDate() {
        return trafficTestDate;
    }

    public void setTrafficTestDate(LocalDate trafficTestDate) {
        this.trafficTestDate = trafficTestDate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "plateNumber='" + plateNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", vintage='" + vintage + '\'' +
                ", trafficTestDate=" + trafficTestDate +
                ", reservations=" + reservations +
                '}';
    }
}
