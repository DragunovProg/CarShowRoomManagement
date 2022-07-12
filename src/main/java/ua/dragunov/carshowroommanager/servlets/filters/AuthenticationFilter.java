package ua.dragunov.carshowroommanager.servlets.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession();
        String loginURI = "/login";

        boolean isLogged = session != null && session.getAttribute("user") != null;
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);

        if (isLogged || isLoginRequest) {
            chain.doFilter(httpRequest, httpResponse);
        } else {
            httpResponse.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
