package jpabucket.bucketlist.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabucket.bucketlist.domain.Member;
import jpabucket.bucketlist.domain.Register;
import jpabucket.bucketlist.domain.item.Item;
import jpabucket.bucketlist.domain.item.ItemFactory;
import jpabucket.bucketlist.domain.item.ItemType;
import jpabucket.bucketlist.repository.ItemRepository;
import jpabucket.bucketlist.repository.MemberRepository;
import jpabucket.bucketlist.repository.RegisterRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RegisterService {

	private final RegisterRepository registerRepository;
	private final MemberRepository memberRepository;
	private final ItemRepository itemRepository;

	/*
	 * 등록
	 */
	@Transactional
	public Long register(Long memberId, ItemType type, String goal, int heart, String detail, int price) {

		// 엔티티 조회
		Member member = memberRepository.findOne(memberId);

		// 등록 아티템 생성 (아이템 생성매소드 사용)
		Item item = ItemFactory.createItem(type, goal, heart, detail, price);

		// 등록 생성
		Register register = Register.createRegister(member, item);

		// 등록 저장
		registerRepository.save(register);

		// 등록 식별자 값 반환
		return register.getId();
	}

	// 달성
	@Transactional
	public void accomplish(Long registerId) {
		// 등록 엔티티 조회
		Register register = registerRepository.findOne(registerId);

		// 등록 아이템 달성
		register.changeStatus();
	}

	// 검색
	// public List<Register> findRegisters(RegisterSearch registerSearch) {
	// 	return registerRepository.findAll(registerSearch);
	// }

}
