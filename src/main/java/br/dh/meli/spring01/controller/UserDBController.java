package br.dh.meli.spring01.controller;

import br.dh.meli.spring01.model.UserBD;
import br.dh.meli.spring01.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin("*") // essa anotação é pra dizer que é pra aceitar requisições de qualquer lugar
@RequestMapping("/user")
public class UserDBController {

    @Autowired
    private UserService service;

    //Get por ID.
    @GetMapping("/{id}")
    public ResponseEntity<UserBD> buscarPorId(@PathVariable long id) {

        return ResponseEntity.ok(service.getUserById(id));
    }


    //Get por Email
    @GetMapping("/email/{email}")
    public ResponseEntity<UserBD> buscarPorId(@PathVariable String email) {

        return ResponseEntity.ok(service.findByEmail(email));
    }

    //Post, postar/criar um novo usuario.
    @PostMapping
    public ResponseEntity<UserBD> insertNewUser(@RequestBody UserBD user){

        return ResponseEntity.status(HttpStatus.CREATED).body(service.insertUser(user));
    }

    //Deletar por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id){

            service.deleteUser(id);
            return ResponseEntity.noContent().build();
    }

    //GetAll (Listar todos)
    @GetMapping
    public ResponseEntity<List<UserBD>> listAll(){

        return ResponseEntity.ok(service.listAll());
    }


    @PutMapping
    public ResponseEntity<UserBD> updateUser(@RequestBody UserBD user){

        return ResponseEntity.ok(service.update(user));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserBD> updateUser(@PathVariable long id, @RequestBody Map<String, String> changes){

        return ResponseEntity.ok(service.updatePartial(id, changes));
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
