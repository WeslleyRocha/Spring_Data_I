package br.dh.meli.spring01.repository;

import br.dh.meli.spring01.model.UserBD;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserBdRepo extends CrudRepository<UserBD, Long> {

	UserBD findByEmail(String email);
}
