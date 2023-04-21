package jpabucket.bucketlist.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("D")
@Getter
@Setter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ToDo extends Item {
	private String way;

	public void editTodo(String goal, String way, String targetDate) {
		this.setGoal(goal);
		this.setWay(way);
		this.setTargetDate(targetDate);
	}
}
