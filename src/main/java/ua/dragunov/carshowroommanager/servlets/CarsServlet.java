package ua.dragunov.carshowroommanager.servlets;

import ua.dragunov.carshowroommanager.model.Car;
import ua.dragunov.carshowroommanager.service.CarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@WebServlet(urlPatterns = {"/cars"})
public class CarsServlet extends HttpServlet {
    private static final CarService carService = new CarService();
    private static List<Car> cars;

    @Override
    public void init() throws ServletException {
        cars = carService.getAllCars();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cars", cars);
        req.getRequestDispatcher("cars.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Car car = new Car();
        car.setMark(req.getParameter("mark"));
        car.setModel(req.getParameter("model"));
        car.setEngine(req.getParameter("engine"));
        car.setReleaseDate(LocalDate.parse(req.getParameter("release_date")));
        car.setPrice(new BigDecimal(String.valueOf(req.getParameter("price"))));
        car.setQuantity(Integer.parseInt(req.getParameter("quantity")));

        carService.createCar(car);

        doGet(req, resp);
    }
}
