package io.kapp.samplemicroservice.order.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.kapp.samplemicroservice.catalog.exception.BaseException;
import io.kapp.samplemicroservice.catalog.exception.CatalogException;
import io.kapp.samplemicroservice.catalog.exception.Response;
import io.kapp.samplemicroservice.order.data.domain.Order;
import io.kapp.samplemicroservice.order.exception.OrderException;
import io.kapp.samplemicroservice.order.service.OrderService;

@RestController
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(OrderException.class);

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> getList() {
		logger.info("OrderController.clazz getList()");
		return new ResponseEntity<List<Order>>(orderService.getAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
	public ResponseEntity<Order> getEntity(@PathVariable("id") long id) throws CatalogException {
		logger.info("OrderController.clazz getEntity() id" + id);

		Order order = orderService.getById(id);
		System.out.println("Order " + order);
		if (order == null || order.getId() <= 0) {
			throw new CatalogException("Order can not be found!");
		}
		return new ResponseEntity<Order>(orderService.getById(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> delete(@PathVariable("id") long id) throws OrderException {
		logger.info("OrderController.clazz delete() id" + id);

		Order order = orderService.getById(id);
		if (order == null || order.getId() <= 0) {
			throw new OrderException("Order to delete can not be found");
		}
		orderService.remove(order);
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Item has been deleted successfully"),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public ResponseEntity<Order> save(@Validated @RequestBody Order order) throws BaseException {
		logger.info("OrderController.clazz save() Item" + order);
		return new ResponseEntity<Order>(orderService.save(order), HttpStatus.OK);
	}

	@RequestMapping(value = "/order", method = RequestMethod.PATCH)
	public ResponseEntity<Order> update(@Validated @RequestBody Order order) throws BaseException {
		logger.info("OrderController.clazz update() Item " + order);
		Order tmp = orderService.getById(order.getId());
		if (tmp == null || tmp.getId() <= 0) {
			throw new CatalogException("Failed, Item doesn't exist");
		}
		return new ResponseEntity<Order>(orderService.save(order), HttpStatus.OK);
	}
}
