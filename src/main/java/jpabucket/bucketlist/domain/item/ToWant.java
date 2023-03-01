package jpabucket.bucketlist.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("W")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ToWant extends Item {
	private String reason;
	private int price;
}
