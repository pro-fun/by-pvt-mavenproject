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
    public boolean deleteGoodFromBasket(Long basketId) {
        Basket basket = basketRepository.getBasketByBasketid(basketId);
        if (basket.getId()==null) {
            return false;
        } else {
            Long count = basket.getCount();
            Long productId = basket.getProductId();
            orderRepository.addCostToOrder(basket.getOrderId(), (-count), productId);
            basketRepository.deleteBasket(basketId);
            return true;
        }
    }

    @Override
    public List<Basket> toSeeGoodsInBasket(Long userid) {
        String state = String.valueOf(INCOMPLETED);
        Long orderId = orderRepository.findOrderNumber(userid, state);
        if (orderId==null){
            orderRepository.addOrder(state,userid);
            orderId = orderRepository.findOrderNumber(userid, state);
        }
        List<Basket> baskets = basketRepository.getBasketsByOrderId(orderId);
        if (baskets.size() ==0) {
            return null;
        } else {
            return baskets;
        }
    }
}
