package org.petstore.endpoint;

import com.org.petstore.endpoint.rest.StoreApi;
import com.org.petstore.endpoint.rest.model.Order;
import org.petstore.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/petstore")
public class OrderController implements StoreApi {

    private OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @Override
    @DeleteMapping(path = "/store/order/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteOrder(Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok().build();
    }

    @Override
    @GetMapping(path = "/store/order/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getOrderById(Long orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    @Override
    @GetMapping(path = "/store/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Integer>> getOrderIds() {
        return ResponseEntity.ok(orderService.getOrderIds());
    }

    @Override
    @PatchMapping(path = "/store/order/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> patchOrder(Long orderId, Order body) {
        return ResponseEntity.ok(orderService.createOrModifyOrder(body));
    }

    @Override
    @PostMapping(path = "/store/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> placeOrder(Order body) {
        return ResponseEntity.ok(orderService.createOrModifyOrder(body));
    }

    @GetMapping(path = "/store/allOrders", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

}
