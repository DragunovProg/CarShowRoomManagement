package ua.dragunov.carshowroommanager.servlets;

import ua.dragunov.carshowroommanager.model.User;
import ua.dragunov.carshowroommanager.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeesServlet", urlPatterns = {"/employees"})
public class EmployeesServlet extends HttpServlet {
    private final UserService userService = new UserService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userService.getAllUsers()
                .stream()
                .filter(user -> !(user.equals((User)request.getSession().getAttribute("user"))))
                .toList();

        request.setAttribute("backUrl", request.getParameter("back"));
        request.setAttribute("employees", users);
        request.getRequestDispatcher("employees.jsp").forward(request, response);
    }

}
