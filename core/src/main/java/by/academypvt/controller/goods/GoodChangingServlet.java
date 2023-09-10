package by.academypvt.controller.goods;

import by.academypvt.api.dto.good.GoodRequest;
import by.academypvt.api.dto.good.Type;
import by.academypvt.config.ApplicationContext;
import by.academypvt.service.GoodService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class GoodChangingServlet extends HttpServlet {
    private final GoodService goodService;

    public GoodChangingServlet() {
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
            if (action.equals("add")) {
                String name = req.getParameter("name");
                Long id = Long.valueOf(req.getParameter("id"));
                Long code = Long.valueOf(req.getParameter("code"));
                Long price = Long.valueOf(req.getParameter("price"));
                Integer quantity = Integer.valueOf(req.getParameter("quantity"));
                String type = req.getParameter("type");
                GoodRequest goodRequest = null;
                if (type.equals("PHONES")) {
                    goodRequest = new GoodRequest(id, Type.PHONES, name, code, price, quantity);
                } else if (type.equals("NOTEBOOKS")) {
                    goodRequest = new GoodRequest(id, Type.NOTEBOOKS, name, code, price, quantity);
                } else if (type.equals("TV")) {
                    goodRequest = new GoodRequest(id, Type.TV, name, code, price, quantity);
                } else if (type.equals("PLAYSTATION")) {
                    goodRequest = new GoodRequest(id, Type.PLAYSTATION, name, code, price, quantity);
                }
                goodService.addGood(goodRequest);
                req.getRequestDispatcher("authorisedControllers/admin.jsp").forward(req,resp);

            } else if (action.equals("delete")) {
                Long idDelete = Long.valueOf(req.getParameter("idDelete"));
                goodService.deleteGood(idDelete);
            } else if (action.equals("find")) {
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
