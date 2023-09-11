package by.academypvt.mapper;

import by.academypvt.api.dto.good.GoodResponse;
import by.academypvt.api.dto.order.OrderRequest;
import by.academypvt.api.dto.order.OrderResponse;
import by.academypvt.domain.Good;
import by.academypvt.domain.Order;

public class OrderMapper {

    public Order mapToOrder(OrderRequest orderRequest) {
        Order order = new Order(orderRequest.getId(), orderRequest.getUserId(), orderRequest.getCost(), orderRequest.getState());
        return order;
    }
    public GoodResponse mapFromGood(Good good){
        GoodResponse goodResponse = new GoodResponse();
        goodResponse.setCode(good.getCode());
        goodResponse.setId(good.getId());
        goodResponse.setType(good.getType());
        goodResponse.setPrice(good.getPrice());
        goodResponse.setName(good.getName());
        goodResponse.setQuantity(good.getQuantity());
        return goodResponse;
    }

    public OrderResponse mapFromOrder(Order order){
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setUserId(order.getUserId());
        orderResponse.setCost(order.getCost());
        orderResponse.setState(order.getState());
        return orderResponse;
    }
}


