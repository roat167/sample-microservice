package io.kapp.samplemicroservice.catalog.web;

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

import io.kapp.samplemicroservice.catalog.data.domain.Item;
import io.kapp.samplemicroservice.catalog.exception.BaseException;
import io.kapp.samplemicroservice.catalog.exception.CatalogException;
import io.kapp.samplemicroservice.catalog.exception.Response;
import io.kapp.samplemicroservice.catalog.service.ItemService;

@RestController
public class CatalogController {
	private static final Logger logger = LoggerFactory.getLogger(CatalogException.class);

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> getList() {
		logger.info("CatalogController.clazz getList()");
		return new ResponseEntity<List<Item>>(itemService.getAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
	public ResponseEntity<Item> getEntity(@PathVariable("id") long id) throws CatalogException {
		logger.info("CatalogController.clazz getEntity() id" + id);

		Item item = itemService.getById(id);
		System.out.println("Item " + item);
		if (item == null || item.getId() <= 0) {
			throw new CatalogException("Item can not be found!");
		}
		return new ResponseEntity<Item>(itemService.getById(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> delete(@PathVariable("id") long id) throws CatalogException {
		logger.info("CatalogController.clazz delete() id" + id);

		Item item = itemService.getById(id);
		if (item == null || item.getId() <= 0) {
			throw new CatalogException("Item to delete can not be found");
		}
		itemService.remove(item);
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Item has been deleted successfully"),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/item", method = RequestMethod.POST)
	public ResponseEntity<Item> save(@Validated @RequestBody Item item) throws BaseException {
		logger.info("CatalogController.clazz save() Item" + item);
		return new ResponseEntity<Item>(itemService.save(item), HttpStatus.OK);
	}

	@RequestMapping(value = "/item", method = RequestMethod.PATCH)
	public ResponseEntity<Item> update(@Validated @RequestBody Item item) throws BaseException {
		logger.info("CatalogController.clazz update() Item " + item);
		Item cust = itemService.getById(item.getId());
		if (cust == null || cust.getId() <= 0) {
			throw new CatalogException("Failed, Item doesn't exist");
		}
		return new ResponseEntity<Item>(itemService.save(item), HttpStatus.OK);
	}
}
