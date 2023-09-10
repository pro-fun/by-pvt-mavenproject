package by.academypvt.controller;

import by.academypvt.config.ApplicationContext;
import by.academypvt.service.UserService;
import jakarta.servlet.http.HttpServlet;

public class AdminServlet extends HttpServlet {
    private final UserService userService;

    public AdminServlet() {
        this.userService = ApplicationContext.getInstance().getUserService();
    }
}
