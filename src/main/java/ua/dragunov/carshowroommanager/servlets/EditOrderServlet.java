package ua.dragunov.carshowroommanager.servlets;

import ua.dragunov.carshowroommanager.model.Car;
import ua.dragunov.carshowroommanager.model.CarSales;
import ua.dragunov.carshowroommanager.service.CarSalesService;
import ua.dragunov.carshowroommanager.service.CarService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@WebServlet(urlPatterns = {"/edit-order"})
public class EditOrderServlet extends HttpServlet {
    private static final CarSalesService orderService = new CarSalesService();
    private static final CarService carService = new CarService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarSales carSales = orderService.getCarSalesById(Long.valueOf(request.getParameter("id")));
        List<Car> cars = carService.getCarsByFilter(carService.getAllCars(),
                car -> car.getId() != carSales.getCar().getId());

        request.setAttribute("cars", cars);
        request.setAttribute("order", carSales);
        request.getRequestDispatcher("edit_order.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarSales carSales = orderService.getCarSalesById(Long.valueOf(request.getParameter("id")));

        carSales.setCar(carService.getCarById(Long.valueOf(request.getParameter("car_select"))));
        carSales.setFullPrice(new BigDecimal(request.getParameter("full_price")));
        carSales.setPurchaseDate(LocalDate.parse(request.getParameter("purchase_date")));

        orderService.updateCarSales(carSales);
        response.sendRedirect("/orders?back="+ request.getParameter("backurl"));
    }
}
