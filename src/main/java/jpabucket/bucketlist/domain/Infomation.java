package jpabucket.bucketlist.domain;

import javax.persistence.Embeddable;

import lombok.Getter;

@Embeddable
@Getter
public class Infomation {

	private String nickname;
	private String password;
	private String email;

	protected Infomation() {
		
	}

	public Infomation(String nickname ,String password, String email) {
		this.nickname = nickname;
		this.password = password;
		this.email = email;
	}
}
