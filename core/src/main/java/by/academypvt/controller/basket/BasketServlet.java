package by.academypvt.controller.basket;

import by.academypvt.config.ApplicationContext;
import by.academypvt.service.BasketService;
import by.academypvt.service.GoodService;
import by.academypvt.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BasketServlet extends HttpServlet {
    private final BasketService basketService;
    private final GoodService goodService;
    private final OrderService orderService;

    public BasketServlet() {
        this.basketService = ApplicationContext.getInstance().getBasketService();
        this.goodService = ApplicationContext.getInstance().getGoodService();
        this.orderService = ApplicationContext.getInstance().getOrderService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession(false);
        Long userid = (Long) session.getAttribute("userid");
        var baskets = basketService.toSeeGoodsInBasket(userid);
        var order = orderService.getOrderForUser(userid);
        if (baskets == null) {
            String message = "В вашей корзине нет товаров";
            req.setAttribute("message", message);
            req.getRequestDispatcher("authorisedControllers/basket.jsp").forward(req, resp);
        } else {
            req.setAttribute("order", order);
            req.setAttribute("baskets", baskets);
            req.getRequestDispatcher("authorisedControllers/basket.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        var session = req.getSession(false);
        Long userid = (Long) session.getAttribute("userid");
        try {
            if (action.equals("add")) {
                Long code = Long.valueOf(req.getParameter("code"));
                Long quantity = Long.valueOf(req.getParameter("quantity"));
                var good = goodService.finGoodByCode(code);
                boolean neededQuantity = goodService.checkGoodsQuantity(quantity, good.getId());
                if (neededQuantity) {
                    orderService.addGoodToBasket(good.getId(), quantity, userid);
                    goodService.changeGoodsQuantity(quantity, good.getId());
                } else {
                    String message = "В магазине нет данного количества товаров";
                    req.setAttribute("message", message);
                    req.getRequestDispatcher("authorisedControllers/basket.jsp").forward(req, resp);
                }
                req.getRequestDispatcher("authorisedControllers/client.jsp").forward(req, resp);
            }else if (action.equals("delete")) {
                Long basketId = Long.valueOf(req.getParameter("basketId"));
                boolean deleteBasket = basketService.deleteGoodFromBasket(basketId);
                if(deleteBasket==false){
                    String message = "В вашей корзине нет товара с данным ID";
                    req.setAttribute("message", message);
                    req.getRequestDispatcher("error.jsp").forward(req, resp);
                }
            }

        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
