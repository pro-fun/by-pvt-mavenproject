package by.academypvt.controller;

import by.academypvt.api.dto.user.UserResponse;
import by.academypvt.config.ApplicationContext;
import by.academypvt.api.dto.user.Role;
import by.academypvt.exception.ClientException;
import by.academypvt.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class AuthorisationServlet extends HttpServlet {
    private final UserService userService;

    public AuthorisationServlet() {
        this.userService = ApplicationContext.getInstance().getUserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var users = userService.usersInfo();
        req.setAttribute("users", users);
        req.getRequestDispatcher("/users.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            UserResponse userResponse = userService.authorization(login, password);
            req.setAttribute("userResponse", userResponse);
            if (userResponse.getRole().equals(Role.ADMIN)) {
                req.getRequestDispatcher("/authorisedControllers/admin.jsp").forward(req, resp);
            } else {
                                req.getRequestDispatcher("/authorisedControllers/client.jsp").forward(req, resp);
            }
        } catch (ClientException e) {
            req.setAttribute("message", e);
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }
}
