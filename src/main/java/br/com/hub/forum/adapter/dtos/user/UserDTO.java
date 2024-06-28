package br.com.hub.forum.adapter.dtos.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserDTO(
        @NotBlank
        String name,
        @NotBlank
        @Email(message = "Formato do email é inválido")
        String email,
        @NotBlank
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&]){8,}.+$")
        String password,
        @NotBlank
        String userName) {
}
