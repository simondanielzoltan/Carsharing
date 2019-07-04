package carsharing.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @Column(name = "login_name")
    private String loginName;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "lisence_end_date")
    private LocalDate lisenceEndDate;


    @OneToMany(mappedBy = "driver")
    private List<Reservation> reservations;

    public Driver() {
    }

    public Driver(String loginName, String password, String fullname, LocalDate lisenceEndDate) {
        this.loginName = loginName;
        this.password = password;
        this.fullname = fullname;
        this.lisenceEndDate = lisenceEndDate;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getLisenceEndDate() {
        return lisenceEndDate;
    }

    public void setLisenceEndDate(LocalDate lisenceEndDate) {
        this.lisenceEndDate = lisenceEndDate;
    }


    @Override
    public String toString() {
        return "Driver{" +
                "loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", lisenceEndDate=" + lisenceEndDate +
                ", reservations=" + reservations +
                '}';
    }
}
