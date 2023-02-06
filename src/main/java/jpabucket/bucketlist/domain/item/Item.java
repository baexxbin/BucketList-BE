package jpabucket.bucketlist.domain.item;

import static javax.persistence.FetchType.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import jpabucket.bucketlist.domain.Category;
import jpabucket.bucketlist.domain.Register;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
public abstract class Item {

	@Id
	@GeneratedValue
	@Column(name = "item_id")
	private Long id;

	private String goal;
	private int heart;

	@OneToOne(mappedBy = "items", fetch = LAZY)
	private Register register;

	@ManyToMany(mappedBy = "items")
	private List<Category> categories = new ArrayList<>();

}