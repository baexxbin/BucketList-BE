package jpabucket.bucketlist.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import jpabucket.bucketlist.repository.ItemRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {
	@Autowired
	ItemRepository itemRepository;

	@Autowired
	ItemService itemService;

	// @Test
	// 	// @Rollback(false)
	// 	// public void 버킷리스트_등록() throws Exception {
	// 	// 	// 	given
	// 	// 	ToDo toDo = new ToDo();
	// 	// 	toDo.setWay("well");
	// 	//
	// 	// 	// 	when
	// 	// 	Long saveId = itemService.saveItem(toDo);
	// 	//
	// 	// 	// 	then
	// 	// 	assertEquals(toDo, itemService.findOne(saveId));
	// 	// }
}
