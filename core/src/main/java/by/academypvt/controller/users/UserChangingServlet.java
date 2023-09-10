package by.academypvt.controller.users;


import by.academypvt.api.dto.user.UserResponse;
import by.academypvt.config.ApplicationContext;
import by.academypvt.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserChangingServlet extends HttpServlet {
    private final UserService userService;

    public UserChangingServlet() {
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
        req.getRequestDispatcher("authorisedControllers/users.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            if (action.equals("add")){
            Long id = Long.valueOf(req.getParameter("id"));
            UserResponse userResponse = userService.findUserById(id);
            if (userResponse != null) {
                req.setAttribute("user", userResponse);
                req.getRequestDispatcher("authorisedControllers/user.jsp").forward(req, resp);
            } else {
                String message = "Пользователя с данным айди не найдено";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/error.jsp").forward(req, resp);
            }
            } else if (action.equals("delete")) {
                Long idDelete = Long.valueOf(req.getParameter("idDelete"));
                userService.deleteUser(idDelete);
            }
        }catch (RuntimeException e) {
            req.setAttribute("message", e);
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }
}