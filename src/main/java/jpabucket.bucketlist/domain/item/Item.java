package jpabucket.bucketlist.domain.item;

import static javax.persistence.FetchType.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jpabucket.bucketlist.domain.Category;
import jpabucket.bucketlist.domain.Heart;
import jpabucket.bucketlist.domain.Register;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Item {

	@Id
	@GeneratedValue
	@Column(name = "item_id")
	private Long id;

	private String goal;
	private int heartCount;
	private LocalDate targetDate;

	@JsonIgnore
	@OneToOne(mappedBy = "item", fetch = LAZY)
	private Register register;

	@ManyToMany(mappedBy = "items")
	private List<Category> categories = new ArrayList<>();

	@OneToMany(mappedBy = "items", cascade = CascadeType.ALL)
	private Set<Heart> hearts = new HashSet<>();

	//==비즈니스 로직==//
	/*
	 * heart 증가
	 */
	public void addHeart() {
		this.heartCount++;
	}

	/*
	 * heart 감소
	 */
	public void decreaseHeart() {
		this.heartCount--;
	}
}
