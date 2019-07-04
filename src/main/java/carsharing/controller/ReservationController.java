package carsharing.controller;

import carsharing.domain.Reservation;
import carsharing.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/add")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.save(reservation));
    }

    @PutMapping("/update")
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.save(reservation));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list-reservation")
    public ResponseEntity<List<Reservation>> listReservation() {
        return ResponseEntity.ok(reservationService.listReservation());
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Reservation> getCarById(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }

    @GetMapping("/get-by-login-name/{loginName}")
    public ResponseEntity<List<Reservation>> getCarsByDriver(@PathVariable String loginName) {
        return ResponseEntity.ok(reservationService.getReservationsByDriver(loginName));
    }

    @GetMapping("/get-by-plate-number/{plateNumber}")
    public ResponseEntity<List<Reservation>> getCarsByCar(@PathVariable String plateNumber) {
        return ResponseEntity.ok(reservationService.getReservationsByCar(plateNumber));
    }

}
