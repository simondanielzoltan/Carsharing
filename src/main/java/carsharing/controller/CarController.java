package carsharing.controller;

import carsharing.domain.Car;
import carsharing.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.save(car));
    }

    @PutMapping("/update")
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.save(car));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable String id) {
        carService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list-cars")
    public ResponseEntity<List<Car>> listCars() {
        return ResponseEntity.ok(carService.listCars());
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable String id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @GetMapping("/get-by-brand/{brand}")
    public ResponseEntity<List<Car>> getCarsByBrand(@PathVariable String brand) {
        return ResponseEntity.ok(carService.listCarsByBrand(brand));
    }

    @GetMapping("/get-by-type/{type}")
    public ResponseEntity<List<Car>> getCarsByType(@PathVariable String type) {
        return ResponseEntity.ok(carService.listCarsByType(type));
    }

    @GetMapping("/list-cars-by-valid-licence")
    public ResponseEntity<List<Car>> listCarsByValidLicence() {
        return ResponseEntity.ok(carService.listCarsByValidLisence());
    }

}
