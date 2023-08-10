package jpabucket.bucketlist.service;

import jpabucket.bucketlist.domain.Heart;
import jpabucket.bucketlist.domain.Member;
import jpabucket.bucketlist.domain.item.Item;
import jpabucket.bucketlist.repository.HeartRepository;
import jpabucket.bucketlist.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HeartService {

    private final HeartRepository heartRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public boolean pressHeart(Member member, Long itemId) {
        Item item = itemRepository.findOne(itemId);
        Optional<Heart> heartOptional = heartRepository.findByMemberAndItem(member, item);

        if (heartOptional.isPresent()) {    // 이미 하트를 누른 경우 하트 취소
//            Heart existingHeart = heartOptional.get();
            heartRepository.deleteByMemberAndItem(member, item);
            item.decreaseHeart();
            return false;
        }
        Heart heart = Heart.createHeart(member, item);  // 새롭게 하트 누를 경우
        heartRepository.save(heart);
        item.addHeart();
        return true;
    }
}
