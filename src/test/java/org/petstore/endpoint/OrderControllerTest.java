package org.petstore.endpoint;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.org.petstore.endpoint.rest.model.Order;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.petstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(OrderController.class)
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
class OrderControllerTest {

	private static final String ORDER_URL = "http://localhost:8080/petstore/";

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private OrderService orderService;

	@InjectMocks
	private OrderController orderController;

	private Order testOrder;

	@Before
	void setUp() {
		testOrder.setId(1L);
		testOrder.setComplete(true);
		testOrder.setQuantity(1);
		testOrder.setPetId(1L);
		testOrder.setShipDate(new Date().toInstant().atOffset(ZoneOffset.UTC));
	}

	@Test
	void deleteOrder() {
	}

	@Test
	void getOrderById() throws Exception {
	}

	@Test
	void getOrderIds() {
	}

	@Test
	void patchOrder() {
	}

	@Test
	void placeOrder() {
	}
}
