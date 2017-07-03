package io.kapp.samplemicroservice.catalog;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.theInstance;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.kapp.samplemicroservice.catalog.data.domain.Item;
import io.kapp.samplemicroservice.catalog.data.repository.ItemRepository;
import io.kapp.samplemicroservice.catalog.exception.DuplicateNameException;
import io.kapp.samplemicroservice.catalog.service.ItemService;
import io.kapp.samplemicroservice.catalog.service.ItemServiceImpl;

@RunWith(SpringRunner.class)
public class ItemServiceTest {

	@Mock
	private ItemRepository itemRepository;

	@InjectMocks
    ItemService itemService = new ItemServiceImpl();

	/**
	 * using BeforeCass wi execute the test once before other Tests
	 */
    @BeforeClass
    public static void setUp() {   
    	//init mock
    	MockitoAnnotations.initMocks(theInstance(ItemServiceTest.class));	    	
    }
	
    @Test
    public void findA() {
    	List<Item> items = new ArrayList<>();    	
    	items.add(new Item("Wireess Mouse", 15));
    	items.add(new Item("Keyboard", 7));
    	items.add(new Item("Monitor", 75.5));
    	when(itemService.getAll()).thenReturn(items);
    	
    	assertEquals(3, itemService.getAll().size());
    }

    @Test
    public void findsByUsername() throws DuplicateNameException {
    	String itemName = "Monitor";
    	Item item = new Item("Monitor", 75.5);
    	itemService.save(item);
    	
    	verify(itemRepository, times(1)).save(item);
		when(itemService.findByName(itemName)).thenReturn(item);
		
		Item resut = itemService.findByName(itemName);		
        assertThat(resut).extracting("name").contains(itemName);        
    }   
    
    @Test
    public void findById() throws DuplicateNameException {
    	Item item = new Item(1L, "Monitor", 75);
    	itemService.save(item);
    	verify(itemRepository, times(1)).save(item);
		when(itemService.getById(1L)).thenReturn(item);
		
		Item resut = itemService.getById(1L);
		assertEquals(1, resut.getId().longValue());
		assertEquals("Monitor", resut.getName());		
    }
    
   @Test 
   public void deeteCustomer() {
		Item item = new Item(1L, "Mouse", 16);		
		itemService.remove(item);
        verify(itemRepository, times(1)).delete(item);
   }
}
