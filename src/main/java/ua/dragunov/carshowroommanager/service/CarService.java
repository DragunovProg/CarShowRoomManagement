package ua.dragunov.carshowroommanager.service;



import ua.dragunov.carshowroommanager.dao.CarDAOImpl;
import ua.dragunov.carshowroommanager.model.Car;

import java.util.List;
import java.util.function.Predicate;

public class CarService {
    private static final CarDAOImpl carDao = new CarDAOImpl();

    public void createCar(Car car) {
        carDao.createCar(car);
    }

    public Car getCarById(Long id) {
        return carDao.getCarById(id);
    }

    public void updateCar(Car car) {
        carDao.updateCar(car);
    }

    public void removeCar(Long carId) {
        carDao.removeCar(carId);
    }

    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }

    public boolean isExistCar(Car car) {
        return car.getQuantity() > 0;
    }

    public List<Car> getCarsByFilter(List<Car> cars, Predicate<Car> predicate) {
        return cars.stream()
                .filter(predicate)
                .toList();
    }


}
