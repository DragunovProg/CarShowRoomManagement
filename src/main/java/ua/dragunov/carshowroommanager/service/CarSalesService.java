package ua.dragunov.carshowroommanager.service;




import ua.dragunov.carshowroommanager.dao.CarSalesDAOImpl;
import ua.dragunov.carshowroommanager.model.CarSales;
import ua.dragunov.carshowroommanager.model.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarSalesService {
    private static final CarSalesDAOImpl carSalesDao = new CarSalesDAOImpl();

    public void createCarSales(CarSales carSales) {
        carSalesDao.createCarSales(carSales);
    }

    public CarSales getCarSalesById(Long id) {
        return carSalesDao.getCarSalesById(id);
    }

    public void updateCarSales(CarSales carSales) {
        carSalesDao.updateCarSales(carSales);
    }

    public void removeCarSales(Long carSalesId) {
        carSalesDao.removeCarSales(carSalesId);
    }

    public List<CarSales> getAllCarSales() {
        return carSalesDao.getAllCarSales();
    }

    public List<CarSales> getCarSalesByUser(List<CarSales> carOrders, User user) {
        return carOrders.stream()
                .filter(carSales -> carSales.getUser().equals(user))
                .toList();
    }


    public long getCountOfSalesByUser(User user) {
        return getAllCarSales().stream()
                .filter(carSales -> carSales.getUser().equals(user))
                .count();
    }

    public Map<User, Long> getUsersLeaderboardBySales() {
        return getAllCarSales().stream()
                .collect(Collectors.groupingBy(CarSales::getUser,
                        Collectors.counting()));
    }

    public Map<User, Long> getUsersLeaderboardByFullPrice() {
        return getAllCarSales().stream()
                .collect(Collectors.groupingBy(CarSales::getUser,
                        Collectors.summingLong(order -> order.getFullPrice().toBigInteger().longValue())));
    }

    /*public static void main(String[] args) {
        CarSalesService orderService = new CarSalesService();

        orderService.getUsersLeaderboardBySales().forEach((user, amountSales) ->
                System.out.printf("%s %s : %d sales\n",user.getLastName(), user.getFirstName(), amountSales   ));
    }
*/
}
