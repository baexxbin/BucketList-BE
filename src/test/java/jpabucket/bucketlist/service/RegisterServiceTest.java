package jpabucket.bucketlist.service;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import jpabucket.bucketlist.domain.Member;
import jpabucket.bucketlist.domain.Register;
import jpabucket.bucketlist.domain.RegisteredStatus;
import jpabucket.bucketlist.domain.item.ItemType;
import jpabucket.bucketlist.repository.RegisterRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class RegisterServiceTest {

	@Autowired
	EntityManager em;

	@Autowired
	RegisterService registerService;

	@Autowired
	RegisterRepository registerRepository;

	@Test
	public void 버킷등록() throws Exception {
		//given
		Member member = new Member();
		member.setName("xubin");
		em.persist(member);

		//when
		ItemType type = ItemType.DO;
		String goal = "테스트 성공";
		String detail = "잘";
		int price = 0;
//		Long registerId = registerService.register(member.getId(), type, goal, detail, price);

		//then
//		Register getRegister = registerRepository.findOne(registerId);

//		Assert.assertEquals("버킷 등록시 상태는 REGISTER", RegisteredStatus.REGISTRATION, getRegister.getStatus());
//		Assert.assertEquals("버킷을 등록한 member는 xubin", "xubin", getRegister.getMember().getName());
//		Assert.assertEquals("버킷의 goal은 테스트 성공", "테스트 성공", getRegister.getItem().getGoal());
	}

	@Test
	public void 버킷달성() throws Exception {
		//given

		//when

		//then
	}

}