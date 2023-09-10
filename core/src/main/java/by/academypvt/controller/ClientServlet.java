package by.academypvt.controller;

import by.academypvt.config.ApplicationContext;
import by.academypvt.service.UserService;
import jakarta.servlet.http.HttpServlet;

public class ClientServlet extends HttpServlet {
    private final UserService userService;

    public ClientServlet() {
        this.userService = ApplicationContext.getInstance().getUserService();
    }

}
