package by.academypvt.service;

import by.academypvt.api.dto.order.OrderResponse;
import by.academypvt.api.dto.order.State;

import java.util.List;

public interface OrderService {
    List<OrderResponse> allOrders();

    List<OrderResponse> toSeeOrders(Long userId);
    void toChangeOrderState(OrderResponse orderResponse);
    void addGoodToBasket(Long goodId, Long quantity, Long userid);
    OrderResponse getOrderForUser (Long userId);
    void deleteOrderById(Long id);
    OrderResponse getOrderById(Long id);
    void toChangeOrderForAdmin(Long id, State state);

}
