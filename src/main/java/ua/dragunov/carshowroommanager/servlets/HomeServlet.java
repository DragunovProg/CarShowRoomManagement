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

    private static<T> void highlightSessionUserInLeaderboard(User user, Map<User, T> leaderboard) {
        leaderboard.forEach((givenUser, value) ->
        {
            if (givenUser.equals(user)) {
                givenUser.setLastName("<b>" + givenUser.getLastName() + "</b>");
                givenUser.setFirstName("<b>" + givenUser.getFirstName() + "</b>");
                givenUser.setEmail("<b>" + givenUser.getEmail() + "</b>");
            }
        });

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<User, Long> leaderboardBySales = getSortedLeaderboard(orderService.getUsersLeaderboardBySales());
        Map<User, Long> leaderboardByFullPrice = getSortedLeaderboard(orderService.getUsersLeaderboardByFullPrice());
        User user = (User) req.getSession().getAttribute("user");
        String homeURI = "/home";
        HomeServlet.highlightSessionUserInLeaderboard(user, leaderboardBySales);
        HomeServlet.highlightSessionUserInLeaderboard(user, leaderboardByFullPrice);

        req.setAttribute("full_price_leaderboard", leaderboardByFullPrice);
        req.setAttribute("sales_leaderboard", leaderboardBySales);
        req.setAttribute("homeURI", homeURI);
        req.setAttribute("user", user);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

    private LinkedHashMap<User, Long> getSortedLeaderboard(Map<User, Long> orderService) {
        return orderService
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

}
