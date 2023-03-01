package ua.minecraftserversite.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.minecraftserversite.entity.User;
import ua.minecraftserversite.exception.LoginException;
import ua.minecraftserversite.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User login(String name, String password) throws LoginException {
        return repository.findByNicknameAndPassword(name,password).orElseThrow(() ->
                new LoginException("Wrong name or password"));
    }
}
