package jpabucket.bucketlist.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("W")
@Getter
@Setter
public class ToWant extends Item {
	private int price;
	private String reason;
}
