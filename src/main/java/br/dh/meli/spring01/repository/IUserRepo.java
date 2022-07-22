package br.dh.meli.spring01.repository;

import br.dh.meli.spring01.model.UserBD;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends CrudRepository<UserBD, Long> {
}
