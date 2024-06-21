package br.com.hub.forum.adapter.controller;

import br.com.hub.forum.adapter.dtos.AuthenticationDTO;
import br.com.hub.forum.infra.security.TokenJWTDTO;
import br.com.hub.forum.domain.models.User;
import br.com.hub.forum.application.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenservice;
    @PostMapping
    public ResponseEntity signin(@RequestBody @Valid AuthenticationDTO data) {
        var token = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var authentication = manager.authenticate(token);

        var generateTokenJWT = tokenservice.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenJWTDTO(generateTokenJWT));
    }
}
