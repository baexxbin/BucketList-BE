package jpabucket.bucketlist.repository;

import jpabucket.bucketlist.domain.RegisteredStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegisterSearch {
    private String memberName; // 회원 이름
    private RegisteredStatus registeredStatus; // 등록상태 [REGISTRATION, ACHIEVEMENT]



}
