package jpabucket.bucketlist.repository;

import jpabucket.bucketlist.domain.Heart;
import jpabucket.bucketlist.domain.Member;
import jpabucket.bucketlist.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface HeartRepository extends JpaRepository<Heart, Long> {
    Optional<Heart> findByMemberAndItem(Member member, Item item);
}
