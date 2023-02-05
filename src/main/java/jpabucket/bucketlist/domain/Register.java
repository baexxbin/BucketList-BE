package jpabucket.bucketlist.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import jpabucket.bucketlist.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "registers")
@Getter
@Setter
public class Register {
	@Id
	@GeneratedValue
	@Column(name = "register_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToOne
	@JoinColumn(name = "item_id")
	private Item items;

	private LocalDateTime registrationDate;
	private LocalDateTime targetDate;

	@Enumerated(EnumType.STRING)
	private RegisteredStatus status;
}
