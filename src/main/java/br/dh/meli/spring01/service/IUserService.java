package br.dh.meli.spring01.service;

import br.dh.meli.spring01.model.UserBD;

import java.util.List;
import java.util.Optional;

public interface IUserService {

	Optional<UserBD> getUserById(long id);
	UserBD insertUser(UserBD newUser);

	void deleteUser(long id);

	List<UserBD> listAll();
}
