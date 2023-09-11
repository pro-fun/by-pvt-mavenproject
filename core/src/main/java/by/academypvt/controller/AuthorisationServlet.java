package by.academypvt.controller;

import by.academypvt.api.dto.user.UserResponse;
import by.academypvt.config.ApplicationContext;
import by.academypvt.api.dto.user.Role;
import by.academypvt.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AuthorisationServlet extends HttpServlet {
    private final UserService userService;

    public AuthorisationServlet() {
        this.userService = ApplicationContext.getInstance().getUserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserResponse> users = null;
        try {
            users = userService.usersInfo();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("users", users);
        req.getRequestDispatcher("/users.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            UserResponse userResponse = userService.authorization(login, password);
            if (userResponse != null) {
                req.setAttribute("userResponse", userResponse);
            } else {
                String message = "Вы ввели неверные данные";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/errorAuthorise.jsp").forward(req, resp);
            }
            var session = req.getSession(true);
            session.setAttribute("userAuthentication", userResponse);
            req.setAttribute("user", userResponse);
            Long userid = userResponse.getUserid();
            session.setAttribute("userid", userid);
            req.setAttribute("user", userResponse);
            if (userResponse.getRole().equals(Role.ADMIN)) {
                req.getRequestDispatcher("/authorisedControllers/admin.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/authorisedControllers/client.jsp").forward(req, resp);
            }
        } catch (RuntimeException e) {
            req.setAttribute("message", e);
            req.getRequestDispatcher("/errorAuthorise.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
