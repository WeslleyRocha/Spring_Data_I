package br.dh.meli.spring01.controller;

import br.dh.meli.spring01.model.UserBD;
import br.dh.meli.spring01.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*") // essa anotação é pra dizer que é pra aceitar requisições de qualquer lugar
@RequestMapping("/user")
public class UserDBController {

    @Autowired
    private UserService service;

    //Get por ID.
    @GetMapping("/{id}")
    public ResponseEntity<UserBD> buscarPorId(@PathVariable long id) {
        Optional<UserBD> userFound = service.getUserById(id);

        if (userFound.isPresent()) {
            return ResponseEntity.ok(userFound.get());

        }
        return ResponseEntity.notFound().build();
    }

    //Post, postar/criar um novo usuario.
    @PostMapping
    public ResponseEntity<UserBD> insertNewUser(@RequestBody UserBD user){
        //TODO: Validar se o user que vai receber tem o ID: retorna uma exception.

        return ResponseEntity.status(HttpStatus.CREATED).body(service.insertUser(user));
    }

    //Deletar por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id){
        Optional<UserBD> userFound = service.getUserById(id);

        if (userFound.isPresent()){
            service.deleteUser(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    //GetAll (Listar todos)
    @GetMapping
    public ResponseEntity<List<UserBD>> listAll(){
        return ResponseEntity.ok(service.listAll());
    }

// Possibilidade de fazer utilizando a URI

//    @PostMapping()
//    public ResponseEntity<User> salvar(@Valid @RequestBody User user, UriComponentsBuilder uriBuilder) {
//        //esta URI sinaliza ao cliente o caminho a ser usado para recuperar o recurso que esta sendo criado.
//        URI uri = uriBuilder
//                .path("/user/{id}")
//                .buildAndExpand(user.getId())
//                .toUri();
//        return ResponseEntity.created(uri).body(id);
//    }
}