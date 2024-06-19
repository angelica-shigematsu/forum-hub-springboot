package br.com.hub.forum.service;

import br.com.hub.forum.dtos.ListUserDTO;
import br.com.hub.forum.models.User;
import br.com.hub.forum.repository.UserRepository;
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
                                userData.getUserName());
    }

    public Optional<User> findById(long id) {
        return repository.findById(id);
    }
}
