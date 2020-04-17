package marko.andrushchenko.networklab1.controllers.rest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import marko.andrushchenko.networklab1.entities.Car;
import marko.andrushchenko.networklab1.service.interfaces.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CarController {
	@Autowired
	CarRepository carRepository;

	@GetMapping("{id}/cars")
	public Car getCar(@PathVariable Long id) {
		return carRepository.getCar(id);
	}

	@GetMapping("/cars")
	public Iterable<Car> getCars() {
		return carRepository.getCars();
	}

	@DeleteMapping("{id}/cars")
	public boolean deleteCar(@PathVariable Long id) {
		return carRepository.deleteCar(id);
	}

	@PatchMapping("{id}/cars")
	public boolean updateCar(@PathVariable Long id, @RequestBody String body) throws JsonProcessingException {
		Car car = new ObjectMapper().readValue(body, Car.class);
		return carRepository.updateCar(car);
	}

	@PutMapping("/cars")
	public boolean createCar(@RequestBody String body) throws JsonProcessingException {
		Car car = new ObjectMapper().readValue(body, Car.class);
		return carRepository.createCar(car);
	}
}
