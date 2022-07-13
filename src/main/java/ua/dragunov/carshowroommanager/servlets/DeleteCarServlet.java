package ua.dragunov.carshowroommanager.servlets;

import ua.dragunov.carshowroommanager.service.CarService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteCarServlet", urlPatterns = {"/delete-car"})
public class DeleteCarServlet extends HttpServlet {
    private static final CarService carService = new CarService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        carService.removeCar(Long.valueOf(request.getParameter("id")));

        response.sendRedirect("/cars?back=" + request.getParameter("backurl"));
    }
}
