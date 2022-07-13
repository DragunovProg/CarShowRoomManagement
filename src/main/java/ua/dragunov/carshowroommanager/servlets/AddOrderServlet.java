package ua.dragunov.carshowroommanager.servlets;

import ua.dragunov.carshowroommanager.model.CarSales;
import ua.dragunov.carshowroommanager.model.User;
import ua.dragunov.carshowroommanager.service.CarSalesService;
import ua.dragunov.carshowroommanager.service.CarService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

@WebServlet(urlPatterns = {"/add-order"})
public class AddOrderServlet extends HttpServlet {
    private static final CarSalesService orderService = new CarSalesService();
    private static final CarService carService = new CarService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("cars", carService.getAllCars());
        request.getRequestDispatcher("add_order.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarSales order = new CarSales();

        order.setCar(carService.getCarById(Long.valueOf(request.getParameter("car_select"))));
        order.setPurchaseDate(LocalDate.parse(request.getParameter("purchase_date")));
        order.setFullPrice(new BigDecimal(request.getParameter("full_price")));
        order.setUser((User) request.getSession().getAttribute("user"));

        orderService.createCarSales(order);
        response.sendRedirect("/orders?back=" + request.getParameter("backurl"));
    }
}
