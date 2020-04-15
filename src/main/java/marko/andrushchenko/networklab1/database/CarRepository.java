package marko.andrushchenko.networklab1.database;

import marko.andrushchenko.networklab1.entities.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
	public Car findCarByIdEquals(Long id);
	public Car deleteCarByIdEquals(Long id);

}
