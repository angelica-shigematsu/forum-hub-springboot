package br.com.hub.forum.adapter.controller;

import br.com.hub.forum.adapter.dtos.user.ListUserDTO;
import br.com.hub.forum.adapter.dtos.user.UserDTO;
import br.com.hub.forum.application.service.UserService;
import br.com.hub.forum.domain.models.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/register")
    public ResponseEntity create(@Valid @RequestBody UserDTO userDto){
        ListUserDTO user = service.addUser(new User(userDto));
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity deleteUser(@PathVariable long id) {
        service.disableUser(id);
        return ResponseEntity.ok("Desabilitado usuário");
    }

}
