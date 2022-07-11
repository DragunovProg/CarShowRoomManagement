package ua.dragunov.carshowroommanager.dao;

import ua.dragunov.carshowroommanager.model.Car;

import java.util.List;

public interface CarDAO {
    void createCar(Car car);

    Car getCarById(Long id);

    void updateCar(Car car);

    void removeCar(Long carId);

    List<Car> getAllCars();
}
