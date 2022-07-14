package ua.dragunov.carshowroommanager.servlets;

import ua.dragunov.carshowroommanager.model.Car;
import ua.dragunov.carshowroommanager.service.CarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/cars"})
public class CarsServlet extends HttpServlet {
    private static final CarService carService = new CarService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> cars = carService.getAllCars();
        req.setAttribute("backUrl", req.getParameter("back"));
        req.setAttribute("cars", cars);
        req.getRequestDispatcher("cars.jsp").forward(req, resp);
    }


}
