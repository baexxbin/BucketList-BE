package jpabucket.bucketlist.repository;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import jpabucket.bucketlist.domain.Register;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RegisterRepository {

	private final EntityManager em;

	public void save(Register register) {
		em.persist(register);
	}

	public Register findOne(Long id) {
		return em.find(Register.class, id);
	}

	// public List<Register> findAll(Register register) {
	//
	// }

}
