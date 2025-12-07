package com.vijay.ecommerce.service;

import com.vijay.ecommerce.client.customer.CustomerClient;
import com.vijay.ecommerce.client.product.ProductClient;
import com.vijay.ecommerce.exception.BusinessException;
import com.vijay.ecommerce.mapper.OrderMapper;
import com.vijay.ecommerce.order.Order;
import com.vijay.ecommerce.order.OrderRequest;
import com.vijay.ecommerce.order.PurchaseRequest;
import com.vijay.ecommerce.orderLine.OrderLine;
import com.vijay.ecommerce.orderLine.OrderLineRequest;
import com.vijay.ecommerce.orderLine.OrderLineService;
import com.vijay.ecommerce.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    private final CustomerClient customerClient;
    private final ProductClient productClient;

    private final OrderLineService orderLineService;

    public Integer createOrder(OrderRequest request) {

        // check customer --> OpenFeign
        var customer  = customerClient.findCustomerById(request.customerId())
                .orElseThrow(()-> new BusinessException("Can not create order with id " + request.customerId()));

        //purchase product --> RestTemplate
        productClient.purchaseProduct(request.products());

        Order order = orderRepository.save(orderMapper.toOrder(request));

        for (PurchaseRequest purchaseRequest : request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        // TODO Start payment
        // sent notifications


        return null;
    }
}
