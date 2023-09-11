package by.academypvt.service;

import by.academypvt.domain.Basket;
import by.academypvt.domain.Order;

import java.util.List;

public interface BasketService {

    boolean deleteGoodFromBasket(Long basketId);
    List<Basket> toSeeGoodsInBasket(Long userid);
}
