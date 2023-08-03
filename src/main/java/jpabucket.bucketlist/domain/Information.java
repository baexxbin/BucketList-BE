package jpabucket.bucketlist.domain;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Information {

	private String nickname;
	private String password;
	private String email;
	private Integer point;

//	protected Information() {
//
//	}
//
//	public Information(String nickname , String password, String email) {
//		this.nickname = nickname;
//		this.password = password;
//		this.email = email;
//	}
}
