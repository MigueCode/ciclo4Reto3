package com.reto3.backend.repository;

import com.reto3.backend.model.Order;
import com.reto3.backend.repository.crud.OrderCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepo {

    @Autowired
    private OrderCrud orderCrud;

    public List<Order> getAll(){
        return orderCrud.findAll();
    }

    public Optional<Order> getOrder(Integer id){
        return orderCrud.findById(id);
    }

    public Order create(Order order){
        return orderCrud.save(order);
    }

    public void update(Order order){
        orderCrud.save(order);
    }

    public void delete(Order order){
        orderCrud.delete(order);
    }

    public List<Order> getOrderByZone(String zone){
        return orderCrud.findBySalesManZone(zone);
    }
}
