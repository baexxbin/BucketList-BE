package jpabucket.bucketlist.service;

import jpabucket.bucketlist.domain.Heart;
import jpabucket.bucketlist.domain.Member;
import jpabucket.bucketlist.domain.item.Item;
import jpabucket.bucketlist.dto.bucket.BaseBucketDto;
import jpabucket.bucketlist.exceptions.CustomException;
import jpabucket.bucketlist.repository.HeartRepository;
import jpabucket.bucketlist.repository.ItemRepository;
import jpabucket.bucketlist.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HeartService {
    private final HeartRepository heartRepository;
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;



    @Transactional
    public void pressHeart(BaseBucketDto baseBucketDto) throws IOException {
        Long memberId = baseBucketDto.getMemberId();
        Long itemId = baseBucketDto.getBucketId();

        Member member = memberRepository.findOne(memberId);     // 리펙토리 예정: 로그인한 사용자 정보 가져오기
        Item item = itemRepository.findOne(itemId);

        Optional<Heart> heartOptional = heartRepository.findByMemberAndItem(member, item);

        if (heartOptional.isPresent()) {    // 이미 하트를 누른 경우
            throw new CustomException("ALREADY_HEARTED");
        }

        Heart heart = Heart.createHeart(member, item);
        heartRepository.save(heart);
        item.addHeart();
    }

    @Transactional
    public void unPressHeart(BaseBucketDto baseBucketDto) throws IOException {

        Long memberId = baseBucketDto.getMemberId();
        Long itemId = baseBucketDto.getBucketId();

        Member member = memberRepository.findOne(memberId);     // 리펙토리 예정: 로그인한 사용자 정보 가져오기
        Item item = itemRepository.findOne(itemId);

        Optional<Heart> heartOptional = heartRepository.findByMemberAndItem(member, item);

        if (heartOptional.isEmpty()) {
            throw new CustomException("HEART_NOT_FOUND");
        }

        heartRepository.deleteByMemberAndItem(member, item);
        item.decreaseHeart();
    }
}
