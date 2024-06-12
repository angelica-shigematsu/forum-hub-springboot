package br.com.hub.forum.dtos;

import br.com.hub.forum.models.User;
import jakarta.validation.constraints.NotNull;

public record ListUserDTO(
        Long id,
        String name,
        String email,
        String userName) {

    public ListUserDTO( Long id,
                        String name,
                        String email,
                        String userName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userName = userName;
    }
}
