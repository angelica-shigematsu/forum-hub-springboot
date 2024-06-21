package br.com.hub.forum.application.service;

import br.com.hub.forum.adapter.dtos.ListUserDTO;
import br.com.hub.forum.domain.models.User;
import br.com.hub.forum.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Transactional
    public ListUserDTO addUser(User user) {
        var userData = repository.save(user);

        return new ListUserDTO(userData.getId(),
                                userData.getFullname(),
                                userData.getEmail(),
                                userData.getUsername());
    }

    public Optional<User> findById(long id) {
        return repository.findById(id);
    }
}
