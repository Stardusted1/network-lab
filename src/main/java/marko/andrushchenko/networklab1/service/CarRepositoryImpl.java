package marko.andrushchenko.networklab1.service;

import marko.andrushchenko.networklab1.entities.Car;
import marko.andrushchenko.networklab1.service.interfaces.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarRepositoryImpl implements CarRepository {

	@Autowired
	marko.andrushchenko.networklab1.database.CarRepository carRepository;
	@Override
	public Car getCar(Long id) {
		return carRepository.findCarByIdEquals(id);
	}

	@Override
	public Iterable<Car> getCars() {
		return carRepository.findAll();
	}

	@Override
	public boolean updateCar(Car car) {
		carRepository.save(car);
		return true;
	}

	@Override
	public boolean deleteCar(Long id) {
		try {
			carRepository.deleteCarByIdEquals(id);
			return true;
		}catch (Exception e){
			return false;
		}
	}

	@Override
	public boolean createCar(Car car) {
		carRepository.save(car);
		return true;
	}
}
