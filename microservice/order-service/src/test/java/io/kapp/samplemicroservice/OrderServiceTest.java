package io.kapp.samplemicroservice;

import static org.hamcrest.CoreMatchers.theInstance;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import io.kapp.samplemicroservice.catalog.data.domain.Item;
import io.kapp.samplemicroservice.order.data.domain.Order;
import io.kapp.samplemicroservice.order.data.domain.OrderStatus;
import io.kapp.samplemicroservice.order.data.repository.OrderRepository;
import io.kapp.samplemicroservice.order.service.OrderService;
import io.kapp.samplemicroservice.order.service.OrderServiceImpl;

@RunWith(SpringRunner.class)
public class OrderServiceTest {

	@Mock
	private OrderRepository orderRepository;

	@InjectMocks
	OrderService orderService = new OrderServiceImpl();

	private Item itemA = new Item("Coca", 15);
	private Item itemB = new Item("Keyboard", 12.5);
	private Item itemC = new Item("Mouse", 7.5);

	/**
	 * using BeforeCass will execute the test once before other Tests
	 */
	@BeforeClass
	public static void setUp() {
		MockitoAnnotations.initMocks(theInstance(OrderServiceTest.class));
	}

	@Test
	public void findA() {
		List<Order> order = new ArrayList<>();
		
		order.add(new Order("kloem", new ArrayList<Item>(Arrays.asList(new Item("Monitor", 25), itemA)), 45, OrderStatus.CREATED));
		order.add(new Order("kloem", new ArrayList<Item>(Arrays.asList(itemA, itemB)), 27.5, OrderStatus.CREATED));
		order.add(new Order("java", new ArrayList<Item>(Arrays.asList(itemA, itemB, itemC)), 35, OrderStatus.CREATED));
		when(orderService.getAll()).thenReturn(order);

		assertEquals(3, orderService.getAll().size());
	}


	@Test
	public void updateOrder() {
		Order order = new Order("kloem", new ArrayList<Item>(Arrays.asList(itemA)), 25, OrderStatus.CREATED);
		order.setOrderStatus(OrderStatus.CANCELLED);
		orderService.save(order);
		assertEquals(OrderStatus.CANCELLED, order.getOrderStatus());
	}

}
