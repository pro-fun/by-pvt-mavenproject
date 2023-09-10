package by.academypvt.repository;

import by.academypvt.api.dto.order.State;
import by.academypvt.domain.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> allOrders();
    List<Order> findOrdersForUser(Long userId);
    Order findOrderById(Long id);
    Order addOrder(String state, Long userId);
    void deleteOrder(Long id);
    void toChangeOrderState(Long orderId, State state);
    List<Order> findOrdersForBasketId(Long basketId);
    Long findOrderNumber(Long userid, String state);
    void addCostToOrder(Long orderId, Long quantity, Long goodId);


}
