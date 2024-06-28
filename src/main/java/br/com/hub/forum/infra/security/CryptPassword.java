package br.com.hub.forum.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CryptPassword {

    @Autowired
    private PasswordEncoder passencoder;
    public String changePasswordCrypt(String password) {
        return passencoder.encode(password);
    }
}
