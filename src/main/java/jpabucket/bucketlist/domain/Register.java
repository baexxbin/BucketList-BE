package jpabucket.bucketlist.domain;

import static javax.persistence.FetchType.*;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
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

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "item_id")
	private Item item;

	private LocalDateTime registrationDate;
	private LocalDateTime targetDate;

	@Enumerated(EnumType.STRING)
	private RegisteredStatus status;

	//==연관관계 메서드==//
	public void setMember(Member member) {
		this.member = member;
		member.getRegisters().add(this);
	}

	public void setItem(Item item) {
		this.item = item;
		item.setRegister(this);

	}

}
