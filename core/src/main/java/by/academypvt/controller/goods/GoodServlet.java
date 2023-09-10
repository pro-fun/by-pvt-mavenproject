package by.academypvt.controller.goods;

import by.academypvt.api.dto.good.GoodRequest;
import by.academypvt.api.dto.good.GoodResponse;
import by.academypvt.api.dto.good.Type;
import by.academypvt.api.dto.user.UserResponse;
import by.academypvt.config.ApplicationContext;
import by.academypvt.exception.ClientException;
import by.academypvt.service.GoodService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class GoodServlet extends HttpServlet {
    private final GoodService goodService;

    public GoodServlet() {
        this.goodService = ApplicationContext.getInstance().getGoodService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var goods = goodService.goodsInfo();
        req.setAttribute("goods", goods);
        req.getRequestDispatcher("authorisedControllers/good.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        try {
        if (action.equals("find")) {
                Long idFind = Long.valueOf(req.getParameter("idFind"));
                var good = goodService.finGoodById(idFind);
                req.setAttribute("good",good);
                req.getRequestDispatcher("authorisedControllers/findedgood.jsp").forward(req,resp);
            }

        } catch (RuntimeException e) {
            req.setAttribute("message", e);
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }
}


