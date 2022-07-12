package ua.dragunov.carshowroommanager.servlets;

import ua.dragunov.carshowroommanager.model.User;
import ua.dragunov.carshowroommanager.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private static final UserService userService = new UserService();

    private static User isCorrectUser(HttpServletRequest request, HttpServletResponse response) {
        return userService.getAllUsers().stream()
                .filter(evaluatedUser -> evaluatedUser.getEmail()
                        .equals(request.getParameter("emailLogin"))
                        && evaluatedUser.getPassword().equals(request.getParameter("passwordLogin")))
                .findFirst()
                .orElse(null);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = isCorrectUser(req, resp);
        HttpSession session = req.getSession();

        if (user != null) {
            session.setAttribute("user", user);

            if (user.getRole().getName().equalsIgnoreCase("employee"))
                resp.sendRedirect("/home");
            if (user.getRole().getName().equalsIgnoreCase("admin"))
                resp.sendRedirect("/admin");

        } else {
            req.setAttribute("error", "User not found");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
