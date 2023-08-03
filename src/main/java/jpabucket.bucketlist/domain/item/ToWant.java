package jpabucket.bucketlist.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("W")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ToWant extends Item {
	private String reason;
	private int price;

	//==생성 매소드==//
	public static ToWant createToWant(String goal, LocalDate targetDate, String reason, int price) {
		ToWant toWant = new ToWant();
		toWant.setGoal(goal);
		toWant.setTargetDate(targetDate);
		toWant.setReason(reason);
		toWant.setPrice(price);
		toWant.setHeart(0);

		return toWant;
	}

	public void editToWant(String goal, LocalDate targetDate, String reason, int price) {
		this.setGoal(goal);
		this.setTargetDate(targetDate);
		this.setReason(reason);
		this.setPrice(price);
	}
}
