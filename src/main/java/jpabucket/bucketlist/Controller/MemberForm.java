package jpabucket.bucketlist.Controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {
    @NotEmpty(message = "회원이름은 필수 입니다.")
    private String name;
    private String nickname;
    private String password;
    private String email;
}
