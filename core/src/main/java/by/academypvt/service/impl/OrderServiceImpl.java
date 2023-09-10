package by.academypvt.service.impl;

import by.academypvt.api.dto.order.OrderRequest;
import by.academypvt.api.dto.order.OrderResponse;
import by.academypvt.api.dto.order.State;
import by.academypvt.domain.Basket;
import by.academypvt.domain.Order;
import by.academypvt.mapper.OrderMapper;
import by.academypvt.repository.BasketRepository;
import by.academypvt.repository.OrderRepository;
import by.academypvt.service.OrderService;

import java.util.List;
import java.util.stream.Collectors;

import static by.academypvt.api.dto.order.State.INCOMPLETED;
import static by.academypvt.api.dto.order.State.WAITING_FOR_DEPART;

public class OrderServiceImpl implements OrderService {
    private BasketRepository basketRepository;

    private OrderRepository orderRepository;
    private OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper,BasketRepository basketRepository) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.basketRepository = basketRepository;
    }

    @Override
    public void addGoodToBasket(Long goodId, Long quantity, Long userid) {
        String state = String.valueOf(INCOMPLETED);
        Long orderId = orderRepository.findOrderNumber(userid,state);
        if (orderId==null){
            Order order = orderRepository.addOrder(state, userid);
            orderId = order.getId();
        }
        basketRepository.addGoodToBasket(goodId,orderId,quantity);
        orderRepository.addCostToOrder(orderId,quantity,goodId);
    }

    @Override
    public OrderResponse getOrderForUser(Long userId) {
        String state = String.valueOf(INCOMPLETED);
        Long orderId = orderRepository.findOrderNumber(userId,state);
        return orderMapper.mapFromOrder(orderRepository.findOrderById(orderId));
    }

    @Override
    public List<OrderResponse> toSeeOrders(Long userId) {
       return orderRepository.findOrdersForUser(userId).stream().map(orderMapper::mapFromOrder).collect(Collectors.toList());
    }

    @Override
    public void toChangeOrderState(OrderResponse orderResponse) {
        State state = WAITING_FOR_DEPART;
        orderRepository.toChangeOrderState(orderResponse.getId(), state);


    }
}
