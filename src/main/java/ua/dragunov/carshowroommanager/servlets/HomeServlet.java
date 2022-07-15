package ua.dragunov.carshowroommanager.servlets;

import ua.dragunov.carshowroommanager.model.User;
import ua.dragunov.carshowroommanager.service.CarSalesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {
    private static final CarSalesService orderService = new CarSalesService();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<User, Long> leaderboardBySales = orderService.getUsersLeaderboardBySales()
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        Map<User, Long> leaderboardByFullPrice = orderService.getUsersLeaderboardByFullPrice()
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        User user = (User) req.getSession().getAttribute("user");
        String homeURI = "/home";

        req.setAttribute("full_price_leaderboard", leaderboardByFullPrice);
        req.setAttribute("sales_leaderboard", leaderboardBySales);
        req.setAttribute("homeURI", homeURI);
        req.setAttribute("user", user);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

}
