package org.petstore.service;

import com.org.petstore.endpoint.rest.model.Order;
import jakarta.transaction.Transactional;
import org.petstore.mapper.OrderMapper;
import org.petstore.persistence.entity.PetOrder;
import org.petstore.persistence.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    private OrderRepository orderRepository;
    private OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper){
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public com.org.petstore.endpoint.rest.model.Order getOrderById(Long id){
        Optional<PetOrder> petOrder = orderRepository.findById(id);
        return orderMapper.mapOrder(petOrder.get());
    }

    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }

    public List<Integer> getOrderIds(){
        List<Integer> orderIds = new LinkedList<Integer>();

        orderRepository.findAll().stream().map(petOrder -> orderIds.add(Math.toIntExact(petOrder.getId())));
        return orderIds;
    }

    public Order createOrModifyOrder(Order body){
        return orderMapper.mapOrder(orderRepository.save(orderMapper.mapPetOrder(body)));
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll()
                        .stream().map(orderMapper::mapOrder).toList();
    }
}
