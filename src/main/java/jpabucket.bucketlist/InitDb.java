package jpabucket.bucketlist;

import jpabucket.bucketlist.domain.Information;
import jpabucket.bucketlist.domain.Member;
import jpabucket.bucketlist.domain.Register;
import jpabucket.bucketlist.domain.item.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
        initService.dbInit2();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit1() {
            Member member = creatMember("xubin", "bini", "1234", "asdf@asd.com", 10);

            em.persist(member);

            LocalDate targetDate = LocalDate.of(2023, 7,6);
            ToDo toDo1 = ToDo.createToDo("스프링 공부", targetDate,"일단합시다");
            em.persist(toDo1);

            LocalDate targetDate2 = LocalDate.of(2023, 6,24);
            ToDo toDo2 = ToDo.createToDo("방콕가기",  targetDate2,"비행기표 끊기");
            em.persist(toDo2);

            Register register1 = Register.createRegister(member, toDo1);
            Register register2 = Register.createRegister(member, toDo2);

            em.persist(register1);
            em.persist(register2);

        }

        public void dbInit2() {
            Member member2 = creatMember("배수빈", "또비니", "qwer123", "qwer@qwer.com", 10);

            em.persist(member2);

            LocalDate targetDate = LocalDate.of(2024, 8,8);
            ToDo toDo1 = ToDo.createToDo("서핑하기", targetDate,"양양 놀러가기");
            em.persist(toDo1);

            LocalDate targetDate2 = LocalDate.of(2023, 12,24);
            ToDo toDo2 = ToDo.createToDo("판교가기",  targetDate2,"공부 열심히하기");
            em.persist(toDo2);

            Register register1 = Register.createRegister(member2, toDo1);
            Register register2 = Register.createRegister(member2, toDo2);

            em.persist(register1);
            em.persist(register2);

        }
    }

    private static Member creatMember(String name, String nickname, String password, String email, Integer point) {
        Member member = new Member();
        member.setName(name);

        Information information = new Information();
        information.setNickname(nickname);
        information.setPassword(password);
        information.setEmail(email);
        information.setPoint(point);

        member.setInformation(information);
        return member;
    }
}
