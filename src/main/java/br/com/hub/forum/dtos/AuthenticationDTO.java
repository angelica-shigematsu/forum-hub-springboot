package br.com.hub.forum.dtos;

public record AuthenticationDTO(
        String email,
        String password) {
}
