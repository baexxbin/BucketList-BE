package jpabucket.bucketlist.repository.register.simplequery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RegisterSimpleQueryRepository {

    private final EntityManager em;

    public List<RegisterSimpleQueryDto> findRegisterDtos() {
        return em.createQuery(
                        "select new jpabucket.bucketlist.repository.register.simplequery.RegisterSimpleQueryDto(r.id, m.name, i.goal, i.targetDate)" +
                                " from Register r" +
                                " join r.member m" +
                                " join r.item i", RegisterSimpleQueryDto.class)
                .getResultList();
    }
}
