package jpabucket.bucketlist.service;

import java.time.LocalDate;
import java.util.List;

import jpabucket.bucketlist.domain.item.ToDo;
import jpabucket.bucketlist.domain.item.ToWant;
import jpabucket.bucketlist.dto.bucket.ItemDto;
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

	public Long createBucket(ItemDto itemDto) {

		if (itemDto instanceof ItemDto.TodoDto) {
			return createTodoBucket((ItemDto.TodoDto) itemDto);
		} else if (itemDto instanceof ItemDto.ToWantDto) {
			return createTowantBucket((ItemDto.ToWantDto) itemDto);
		}
		/**
		 * 예외처리하기
		 * @ExceptionHandler 어노테이션을 사용하여 컨트롤러 클래스 내에 전역적인 예외 처리 핸들러 정의
		 */

		return null;
	}

	@Transactional
	public Long createTodoBucket(ItemDto.TodoDto todoDto) {
		ToDo toDo = ToDo.createToDo(
				todoDto.getGoal(),
				todoDto.getTargetDate(),
				todoDto.getWay()
		);
		saveItem(toDo);
		return toDo.getId();
	}

	@Transactional
	public Long createTowantBucket(ItemDto.ToWantDto toWantDto) {
		ToWant toWant = ToWant.createToWant(
				toWantDto.getGoal(),
				toWantDto.getTargetDate(),
				toWantDto.getReason(),
				toWantDto.getPrice()
		);
		saveItem(toWant);
		return toWant.getId();
	}

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
