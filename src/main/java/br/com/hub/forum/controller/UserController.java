package br.com.hub.forum.controller;

import br.com.hub.forum.dtos.ListUserDTO;
import br.com.hub.forum.dtos.UserDTO;
import br.com.hub.forum.exceptions.FindUserEmailException;
import br.com.hub.forum.models.User;
import br.com.hub.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/register")
    public ResponseEntity<Object> create(@RequestBody UserDTO userDto) throws FindUserEmailException {
        try {
            ListUserDTO user = service.addUser(new User(userDto));

            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (FindUserEmailException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
