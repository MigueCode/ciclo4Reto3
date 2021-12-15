package com.reto3.backend.repository.crud;

import com.reto3.backend.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderCrud extends MongoRepository<Order, Integer> {
    List<Order> findBySalesManZone(String zone);
}
