package ua.dragunov.carshowroommanager.servlets;

import ua.dragunov.carshowroommanager.model.Car;
import ua.dragunov.carshowroommanager.service.CarService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

@WebServlet(urlPatterns = {"/add"})
public class AddCarServlet extends HttpServlet {
    private static final CarService carService = new CarService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getParameter("backurl");
        Car car = new Car();

        car.setMark(request.getParameter("mark"));
        car.setModel(request.getParameter("model"));
        car.setEngine(request.getParameter("engine"));
        car.setReleaseDate(LocalDate.parse(request.getParameter("releaseDate")));
        car.setPrice(new BigDecimal(request.getParameter("price")));
        car.setQuantity(Integer.parseInt(request.getParameter("quantity")));

        carService.createCar(car);
        response.sendRedirect("/cars?back=" + url);

    }
}
