package br.com.hub.forum.controller;

import br.com.hub.forum.dtos.ListUserDTO;
import br.com.hub.forum.dtos.UserDTO;
import br.com.hub.forum.models.User;
import br.com.hub.forum.service.UserService;
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
    public ResponseEntity<Object> create(@Valid @RequestBody UserDTO userDto){
        ListUserDTO user = service.addUser(new User(userDto));
        return ResponseEntity.ok(user);
    }
}
