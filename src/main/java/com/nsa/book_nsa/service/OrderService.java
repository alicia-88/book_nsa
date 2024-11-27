package com.nsa.book_nsa.service;

import com.nsa.book_nsa.exception.NotFoundException;
import com.nsa.book_nsa.model.Order;
import com.nsa.book_nsa.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException("order", id));
    }
    public Order addOrder(Order orderDetails) {
        // userService.getUserById(orderDetails.getUser().getId());
        return orderRepository.save(orderDetails);
    }
    public Order updateOrder(Long id, Order orderDetails) {
        Order updatedOrder = getOrderById(id);
        updatedOrder.setDate(orderDetails.getDate());
        updatedOrder.setTotal(orderDetails.getTotal());
        updatedOrder.setQuantity(orderDetails.getQuantity());
        return orderRepository.save(orderDetails);
    }
    public void deleteOrder(Long id) {
        Order deletedOrder = getOrderById(id);
        orderRepository.deleteById(deletedOrder.getId());
    }
}
