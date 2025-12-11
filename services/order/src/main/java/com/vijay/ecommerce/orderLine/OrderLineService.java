package com.vijay.ecommerce.orderLine;

import com.vijay.ecommerce.mapper.OrderLineMapper;
import com.vijay.ecommerce.order.Order;
import com.vijay.ecommerce.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLineService {
    private final OrderLineRepository repository;
    private final OrderLineMapper mapper;

    public Integer saveOrderLine(OrderLineRequest request) {

        OrderLine order = mapper.toOrderLine(request);
        return repository.save(order).getId();
    }

    public List<OrderLineResponse> findAllByOrderId(Integer orderId) {
        return repository.findAllByOrderId(orderId).stream()
                .map(mapper::fromOrderLineResponse)
                .toList();
    }
}
