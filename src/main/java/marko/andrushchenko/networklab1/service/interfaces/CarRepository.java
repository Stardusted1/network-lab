package marko.andrushchenko.networklab1.service.interfaces;

import marko.andrushchenko.networklab1.entities.Car;

public interface CarRepository {
	public Car getCar(Long id);
	public Iterable<Car> getCars();
	public boolean updateCar(Car car);
	public boolean deleteCar(Long id);
	public boolean createCar(Car car);
}
