package by.academypvt.service;

import by.academypvt.api.dto.order.OrderRequest;
import by.academypvt.api.dto.order.OrderResponse;
import by.academypvt.domain.Basket;
import by.academypvt.domain.Order;

import java.util.List;

public interface OrderService {

    List<OrderResponse> toSeeOrders(Long userId);
    void toChangeOrderState(OrderResponse orderResponse);
    void addGoodToBasket(Long goodId, Long quantity, Long userid);
    OrderResponse getOrderForUser (Long userId);

}
