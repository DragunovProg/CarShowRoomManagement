package ua.dragunov.carshowroommanager.servlets;

import ua.dragunov.carshowroommanager.service.CarSalesService;
import ua.dragunov.carshowroommanager.service.CarService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/delete-order"})
public class DeleteOrderServlet extends HttpServlet {
    private static final CarSalesService orderService = new CarSalesService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        orderService.removeCarSales(Long.valueOf(request.getParameter("id")));

        response.sendRedirect("/orders?back=" + request.getParameter("backurl"));
    }
}
