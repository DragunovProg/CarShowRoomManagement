package ua.dragunov.carshowroommanager.servlets;

import ua.dragunov.carshowroommanager.model.Car;
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

@WebServlet(urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {
    private static final CarSalesService orderService = new CarSalesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<User, Long> leaderboardBySales = getSortedLeaderboard(orderService.getUsersLeaderboardBySales());
        Map<Car, Long> carRating = getSortedCarRating(orderService.getCarRatingBySales());
        User user = (User) req.getSession().getAttribute("user");
        String homeURI = "/admin";

        req.setAttribute("car_rating", carRating);
        req.setAttribute("all_sales", orderService.getAllCarSales().size());
        req.setAttribute("sales_leaderboard", leaderboardBySales);
        req.setAttribute("homeURI", homeURI);
        req.getRequestDispatcher("admin.jsp").forward(req, resp);
    }

    private LinkedHashMap<User, Long> getSortedLeaderboard(Map<User, Long> orderService) {
        return orderService
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    private LinkedHashMap<Car, Long> getSortedCarRating(Map<Car, Long> orderService) {
        return orderService
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
