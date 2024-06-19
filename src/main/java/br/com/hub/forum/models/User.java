package br.com.hub.forum.models;

import br.com.hub.forum.dtos.UserDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Entity
@Table(name="user")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    @Column(nullable = false)
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ\\.\\-\\'\\ ]+$")
    private String fullname;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}")
    private String password;

    @Column(unique = true)
    private String userName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TopicModel> topic;

    public User(UserDTO userDto) {
        this.fullname = userDto.name();
        this.email = userDto.email();
        this.password = userDto.password();
        this.userName = userDto.userName();
    }
}
