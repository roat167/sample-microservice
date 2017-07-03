package io.kapp.samplemicroservice.catalog.data.repository;

import io.kapp.samplemicroservice.catalog.data.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

	public Item findFirstByName(String name);
}
