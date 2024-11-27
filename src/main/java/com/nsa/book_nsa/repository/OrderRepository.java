package com.nsa.book_nsa.repository;

import com.nsa.book_nsa.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
