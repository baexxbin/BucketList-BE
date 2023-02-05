package jpabucket.bucketlist.domain;

import javax.persistence.Embeddable;

import lombok.Getter;

@Embeddable
@Getter
public class Infomation {

	private String password;
	private String email;

	protected Infomation() {
		
	}

	public Infomation(String password, String email) {
		this.password = password;
		this.email = email;
	}
}
