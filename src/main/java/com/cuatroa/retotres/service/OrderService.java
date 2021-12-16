package com.cuatroa.retotres.service;

import com.cuatroa.retotres.model.Order;
import com.cuatroa.retotres.repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author  Olga Patricia Bernal
 * @version 1.0
 * @since   2021-12-14
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderRepository.getOrder(id);
    }

     public Order create(Order order){
        if(order.getId()!= null){
            return orderRepository.create(order);
        }else{
            return order;
        }
    }

     public Order update(Order order) {
        if (order.getId() != null) {
            Optional<Order> orden = orderRepository.getOrder(order.getId());
            if(!orden.isEmpty()) {

                if (order.getId() != null) {
                    orden.get().setId(order.getId());
                }
                if (order.getRegisterDay() != null) {
                    orden.get().setRegisterDay(order.getRegisterDay());
                }
                if (order.getStatus() != null) {
                    orden.get().setStatus(order.getStatus());
                }
                if (order.getSalesMan() != null) {
                    orden.get().setStatus(order.getStatus());
                }
                if (order.getSalesMan() != null) {
                    orden.get().setSalesMan(order.getSalesMan());
                }

                if (order.getProducts() != null) {
                    orden.get().setProducts(order.getProducts());
                }

                if (order.getQuantities() != null) {
                    orden.get().setQuantities(order.getQuantities());
                }
                orderRepository.update(orden.get());
                return orden.get();
            }else{
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(Integer id) {
        return getOrder(id).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);        
    }

    //Ordenes de pedido asociadas a los asesores de una zona
    public List<Order> getZone(String zone) {
        return orderRepository.getZone(zone);
    }
    
    //Métodos del reto 4
    //Reto 4: Ordenes de un asesor
    public List<Order> getBySalesManId(Integer id){
        return orderRepository.getBySalesManId(id);
    }
    //Reto 4: Ordenes de un asesor x Estado
    public List<Order> getBySalesManIdAndStatus(Integer id, String status){
        return orderRepository.getBySalesManIdAndStatus(id, status);
    }
    //Reto 4: Ordenes de un asesor x fecha
    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        return orderRepository.getByRegisterDayAndSalesManId(registerDay,id);
    }
}
