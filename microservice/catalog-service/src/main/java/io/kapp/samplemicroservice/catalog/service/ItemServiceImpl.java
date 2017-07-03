package io.kapp.samplemicroservice.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kapp.samplemicroservice.catalog.data.domain.Item;
import io.kapp.samplemicroservice.catalog.data.repository.ItemRepository;
import io.kapp.samplemicroservice.catalog.exception.DuplicateNameException;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item getById(Long id) {
		return itemRepository.findOne(id);
	}

	@Override
	public Item save(Item item) throws DuplicateNameException {
		Item temp = itemRepository.findFirstByName(item.getName());
		
		if (temp != null && !(temp.getId().equals(item.getId()))) {
			throw new DuplicateNameException("Item name already exists!");
		}
		return itemRepository.save(item);
	}

	@Override
	public void remove(Item item) {
		itemRepository.delete(item);
	}

	@Override
	public void remove(Long id) {
		itemRepository.delete(id);
	}

	@Override
	public List<Item> getAll() {
		return itemRepository.findAll();
	}

	@Override
	public Item findByName(String name) {
		return itemRepository.findFirstByName(name);
	}
}
