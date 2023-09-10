package by.academypvt.controller.orders;

import by.academypvt.config.ApplicationContext;
import by.academypvt.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class OrderServlet extends HttpServlet {
    private final OrderService orderService;

    public OrderServlet() {
        this.orderService = ApplicationContext.getInstance().getOrderService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession(false);
        Long userid = (Long) session.getAttribute("userid");
        var order = orderService.getOrderForUser(userid);
        orderService.toChangeOrderState(order);
        req.getRequestDispatcher("authorisedControllers/basket.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession(false);
        Long userid = (Long) session.getAttribute("userid");
        try {
            var orders = orderService.toSeeOrders(userid);
            req.setAttribute("orders", orders);
            req.getRequestDispatcher("authorisedControllers/order.jsp").forward(req, resp);

        } catch (RuntimeException e) {
            req.setAttribute("message", e);
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }

}
