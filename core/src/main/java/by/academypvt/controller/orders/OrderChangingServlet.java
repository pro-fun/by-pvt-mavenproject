package by.academypvt.controller.orders;


import by.academypvt.config.ApplicationContext;
import by.academypvt.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class OrderChangingServlet extends HttpServlet {
    private final OrderService orderService;

    public OrderChangingServlet() {

        this.orderService = ApplicationContext.getInstance().getOrderService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var orders = orderService.allOrders();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("authorisedControllers/order.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
                if (action.equals("delete")) {
                    Long idDelete = Long.valueOf(req.getParameter("idDelete"));
                    orderService.deleteOrderById(idDelete);
                } else if (action.equals("find")) {
                    Long idFind = Long.valueOf(req.getParameter("idFind"));
                    var order = orderService.getOrderById(idFind);
                    req.setAttribute("order",order);
                    req.getRequestDispatcher("authorisedControllers/findedorder.jsp").forward(req,resp);
                }
              }catch (RuntimeException e) {
            req.setAttribute("message", e);
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }
}
