package ua.dragunov.carshowroommanager.servlets;

import ua.dragunov.carshowroommanager.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteEmployeeServlet", urlPatterns = {"/delete-employee"})
public class DeleteEmployeeServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userService.removeUser(Long.valueOf(request.getParameter("id")));
        response.sendRedirect("/employees?back=" + request.getParameter("backurl"));
    }
}
