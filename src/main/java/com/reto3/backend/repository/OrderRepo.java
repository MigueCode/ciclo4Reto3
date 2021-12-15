package com.reto3.backend.repository;

import com.reto3.backend.model.Order;
import com.reto3.backend.repository.crud.OrderCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepo {

    @Autowired
    private OrderCrud orderCrud;

    @Autowired
    private MongoTemplate mongoTemplate;

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

    public List<Order> ordersSalesManById(Integer id){
        Query query = new Query();
        Criteria criteria = Criteria.where("salesMan.id").is(id);

        query.addCriteria(criteria);

        List<Order> orders = mongoTemplate.find(query, Order.class);

        return orders;
    }

    public List<Order> ordersSalesManByState(String state, Integer id){
        Query query = new Query();
        Criteria criteria = Criteria.where("salesMan.id").is(id).and("status").is(state);

        query.addCriteria(criteria);

        List<Order> orders = mongoTemplate.find(query, Order.class);

        return orders;
    }

    public List<Order> ordersSalesManByDate(String dateStr, Integer id){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Query query = new Query();

        Criteria criteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(dateStr, dtf).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(criteria);

        List<Order> orders = mongoTemplate.find(query, Order.class);

        return orders;

    }
}
