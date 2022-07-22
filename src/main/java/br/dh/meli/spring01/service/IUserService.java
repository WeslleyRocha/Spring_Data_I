package br.dh.meli.spring01.service;

import br.dh.meli.spring01.model.UserBD;
import org.apache.catalina.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IUserService {

	//esses são métodos abstratos que serão implementados na classe "UserService"
	//Metodo que eu faz o GET por ID
	UserBD getUserById(long id);

	//Metodo que cria um novo usuario "insertUser"
	UserBD insertUser(UserBD newUser);

	//Metodo sem retorno "VOID" para deletar o user por id
	void deleteUser(long id);

	//Metodo que lista todos os usuario.
	List<UserBD> listAll();

	UserBD update(UserBD updateUser);

	UserBD updatePartial (long id, Map<String,String> changes);

	UserBD findByEmail(String email);
}
