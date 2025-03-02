package org.petstore.endpoint;

import com.org.petstore.endpoint.rest.StoreApi;
import com.org.petstore.endpoint.rest.model.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class OrderController implements StoreApi {

    @Override
    public ResponseEntity<Void> deleteOrder(Long orderId) {
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Order> getOrderById(Long orderId) {
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Integer>> getOrderIds() {
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Order> patchOrder(Long orderId, Order body) {
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Order> placeOrder(Order body) {
        return ResponseEntity.noContent().build();
    }
}
