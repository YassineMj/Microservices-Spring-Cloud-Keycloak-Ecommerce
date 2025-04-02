package com.yassine.ecommerce.orderline.mapper;

import com.yassine.ecommerce.order.model.Order;
import com.yassine.ecommerce.order.model.Order;
import com.yassine.ecommerce.orderline.request.OrderLineRequest;
import com.yassine.ecommerce.orderline.response.OrderLineResponse;
import com.yassine.ecommerce.orderline.model.OrderLine;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
                .id(request.orderId())
                .productId(request.productId())
                .order(
                        Order.builder()
                                .id(request.orderId())
                                .build()
                )
                .quantity(request.quantity())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(
                orderLine.getId(),
                orderLine.getQuantity()
        );
    }
}
