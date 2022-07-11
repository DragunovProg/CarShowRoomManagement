package ua.dragunov.carshowroommanager.dao;


import ua.dragunov.carshowroommanager.model.CarSales;

import java.util.List;

public interface CarSalesDAO {
    void createCarSales(CarSales carSales);

    CarSales getCarSalesById(Long id);

    void updateCarSales(CarSales carSales);

    void removeCarSales(Long carSalesId);

    List<CarSales> getAllCarSales();

}
