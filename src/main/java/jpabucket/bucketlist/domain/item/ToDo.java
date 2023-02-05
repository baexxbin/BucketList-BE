package jpabucket.bucketlist.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("D")
@Getter
@Setter
public class ToDo extends Item {
	private String way;
}
