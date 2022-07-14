package ua.dragunov.carshowroommanager.servlets;

import ua.dragunov.carshowroommanager.model.Car;
import ua.dragunov.carshowroommanager.model.CarSales;
import ua.dragunov.carshowroommanager.model.User;
import ua.dragunov.carshowroommanager.service.CarSalesService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "OrdersServlet", urlPatterns = {"/orders"})
public class OrdersServlet extends HttpServlet {
    private static final CarSalesService orderService = new CarSalesService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        List<CarSales> orders = orderService.getAllCarSales();

        if (user.getRole().getName().equalsIgnoreCase("employee")) {
            orders.retainAll(orderService.getCarSalesByUser(orders, user));
        }

        request.setAttribute("backUrl", request.getParameter("back"));
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("orders.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
