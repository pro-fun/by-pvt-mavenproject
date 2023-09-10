package by.academypvt.service.impl;

import by.academypvt.domain.Basket;
import by.academypvt.domain.Order;
import by.academypvt.repository.BasketRepository;
import by.academypvt.repository.GoodRepository;
import by.academypvt.repository.OrderRepository;
import by.academypvt.service.BasketService;

import java.util.List;

import static by.academypvt.api.dto.order.State.INCOMPLETED;

public class BasketServiceImpl implements BasketService {
    private BasketRepository basketRepository;
    private OrderRepository orderRepository;
    private GoodRepository goodRepository;

    public BasketServiceImpl(BasketRepository basketRepository, OrderRepository orderRepository, GoodRepository goodRepository) {
        this.basketRepository = basketRepository;
        this.orderRepository = orderRepository;
        this.goodRepository = goodRepository;
    }


    @Override
    public void deleteGoodFromBasket(Long basketId) {
        Basket basket = basketRepository.getBasketByBasketid(basketId);
        Long count = basket.getCount();
        Long prosuctId = basket.getProductId();
        orderRepository.addCostToOrder(basket.getOrderId(),(-basket.getCount()),basket.getProductId());
        basketRepository.deleteBasket(basketId);
        }

    @Override
    public List<Basket> toSeeGoodsInBasket(Long userid) {
        String state = String.valueOf(INCOMPLETED);
        Long orderId = orderRepository.findOrderNumber(userid, state);
        List<Basket> baskets = basketRepository.getBasketsByOrderId(orderId);
        if (baskets == null) {
            return null;
        } else {
            return baskets;
        }
    }
}
