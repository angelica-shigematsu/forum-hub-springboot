package br.com.hub.forum.service;

import br.com.hub.forum.dtos.ListUserDTO;
import br.com.hub.forum.exceptions.FindUserEmailException;
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
    public ListUserDTO addUser(User user) throws FindUserEmailException {

        Optional<User> findUser = repository.findByEmail(user.getEmail());

        if (findUser.isPresent()) throw new FindUserEmailException();

        var userData = repository.save(user);
        return new ListUserDTO(userData.getId(),
                                userData.getName(),
                                userData.getEmail(),
                                userData.getUserName());
    }

}
