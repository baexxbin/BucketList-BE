package jpabucket.bucketlist.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("D")
@Getter
@Setter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ToDo extends Item {
	private String way;

	//==생성 매소드==//
	public static ToDo createToDo(String goal, LocalDate targetDate, String way) {
		ToDo toDo = new ToDo();
		toDo.setGoal(goal);
		toDo.setTargetDate(targetDate);
		toDo.setHeart(0);
		toDo.setWay(way);

		return toDo;
	}

	public void editTodo(String goal, String way, LocalDate targetDate) {
		this.setGoal(goal);
		this.setWay(way);
		this.setTargetDate(targetDate);
	}
}
