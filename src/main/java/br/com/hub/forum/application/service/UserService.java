package br.com.hub.forum.application.service;

import br.com.hub.forum.adapter.dtos.user.ListUserDTO;
import br.com.hub.forum.domain.models.User;
import br.com.hub.forum.infra.repository.UserRepository;
import br.com.hub.forum.infra.security.CryptPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private CryptPassword cryptPassword;

    @Transactional
    public ListUserDTO addUser(User user) {
        user.setPassword(cryptPassword.changePasswordCrypt(user.getPassword()));

        var userData = repository.save(user);

        return new ListUserDTO(userData.getId(),
                                userData.getFullname(),
                                userData.getEmail(),
                                userData.getUsername());
    }

    public Optional<User> findById(long id) {
        return repository.findById(id);
    }

    public void disableUser(long id) {
        var user = repository.getReferenceById(id);
        user.setActive(false);
        repository.save(user);
    }
}
