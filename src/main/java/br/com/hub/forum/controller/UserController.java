package br.com.hub.forum.controller;

import br.com.hub.forum.dtos.ListUserDTO;
import br.com.hub.forum.dtos.UserDTO;
import br.com.hub.forum.models.User;
import br.com.hub.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/register")
    public ListUserDTO create(@RequestBody UserDTO userDto) {
        return service.addUser(new User(userDto));
    }
}
