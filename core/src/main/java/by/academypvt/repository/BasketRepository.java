package by.academypvt.repository;

import by.academypvt.domain.Basket;


import java.util.List;

public interface BasketRepository {
    List<Basket> allBaskets();

    void addGoodToBasket(Long productId, Long orderId, Long count);

    Basket getBasketByBasketid(Long basketId);


    void deleteBasket(Long basketId);

    List<Basket> getBasketsByOrderId(Long orderId);
}
