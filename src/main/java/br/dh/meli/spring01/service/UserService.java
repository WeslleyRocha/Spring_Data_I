package br.dh.meli.spring01.service;


import br.dh.meli.spring01.exception.BadRequestException;
import br.dh.meli.spring01.exception.UserNotFoundException;
import br.dh.meli.spring01.model.UserBD;
import br.dh.meli.spring01.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepo repo;

    @Override
    public UserBD getUserById(long id) {
        return repo.findById(id).orElseThrow(()-> new UserNotFoundException("ID não encontrado: " + id));

    }

    @Override
    public UserBD insertUser(UserBD newUser) {

    //Verifica se recebeu um USER com ID, caso ele tenha o ID ele rejeita por é um user ja cadastrado.
    if (newUser.getId() >0) {
        throw new BadRequestException("O campo ID não pode ser preenchido para novos usuarios!");
    }
        return repo.save(newUser);

    }

    @Override
    public void deleteUser(long id) {

      UserBD userFound = getUserById(id);
      repo.delete(userFound);

    }

    @Override
    public List<UserBD> listAll() {
        return (List<UserBD>) repo.findAll();
    }
}
