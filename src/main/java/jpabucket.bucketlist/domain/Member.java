package jpabucket.bucketlist.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
	@Id
	@GeneratedValue
	@Column(name = "member_id")
	private Long id;

	private String name;

	@Embedded
	private Information information;

	@JsonIgnore
	@OneToMany(mappedBy = "member")
	private List<Register> registers = new ArrayList<>();
}
