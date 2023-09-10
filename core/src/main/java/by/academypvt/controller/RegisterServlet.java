package by.academypvt.controller;

import by.academypvt.api.dto.user.UserRequest;
import by.academypvt.api.dto.user.UserResponse;
import by.academypvt.config.ApplicationContext;
import by.academypvt.exception.ClientException;
import by.academypvt.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static by.academypvt.api.dto.user.Role.CLIENT;

public class RegisterServlet extends HttpServlet {
    private final UserService userService;

    public RegisterServlet() {
        this.userService = ApplicationContext.getInstance().getUserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var users = userService.usersInfo();
        PrintWriter printWriter = resp.getWriter();
        resp.setContentType("text/html");
        printWriter.println(users.toString());
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserRequest userRequest = new UserRequest(name, surname, login, password, CLIENT);
        try{
            userService.registration(userRequest);

        List<UserResponse> users = userService.usersInfo();
        req.setAttribute("users", users);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (ClientException e){
            req.setAttribute("message", e);
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }

}
