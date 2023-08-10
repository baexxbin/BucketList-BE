package jpabucket.bucketlist.domain;

import static javax.persistence.FetchType.*;

import jpabucket.bucketlist.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "heart")
@Getter
@Setter
public class Heart {

    @Id
    @GeneratedValue
    @Column(name = "heart_id")
    private Long id;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    //==생성 메서드==//
    public static Heart createHeart(Member member, Item item) {
        Heart heart = new Heart();
        heart.setMember(member);
        heart.setItem(item);

        return heart;
    }
}
