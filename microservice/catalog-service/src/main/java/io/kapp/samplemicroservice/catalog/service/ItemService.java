package io.kapp.samplemicroservice.catalog.service;

import java.util.List;

import io.kapp.samplemicroservice.catalog.data.domain.Item;
import io.kapp.samplemicroservice.catalog.exception.DuplicateNameException;

public interface ItemService {
	Item getById(Long id);	
	Item save(Item item) throws DuplicateNameException;
	void remove(Item customer);
	void remove(Long id);
	Item findByName(String name);
	List<Item> getAll();
}
