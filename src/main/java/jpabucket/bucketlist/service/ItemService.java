package jpabucket.bucketlist.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jpabucket.bucketlist.domain.item.ToDo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabucket.bucketlist.domain.item.Item;
import jpabucket.bucketlist.repository.ItemRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

	private final ItemRepository itemRepository;

	@Transactional
	public void saveItem(Item item) {
		itemRepository.save(item);
	}

//	@Transactional
//	public Item updateItem(Long itemId, String goal, String way, String targetDate) {
//		Item findItem = itemRepository.findOne(itemId);
//		findItem.setGoal(goal);
//	}

	@Transactional
	public void updateTodo(Long itemId, String goal, String way, LocalDate targetDate) {
		ToDo findItem = (ToDo) itemRepository.findOne(itemId);
		findItem.editTodo(goal, way, targetDate);
	}

	public List<Item> findItems() {
		return itemRepository.findAll();
	}

	public Item findOne(Long itemId) {
		return itemRepository.findOne(itemId);
	}
}
