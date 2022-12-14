package ua.minecraftserversite.service;

import org.springframework.stereotype.Service;
import ua.minecraftserversite.entity.User;
import ua.minecraftserversite.exception.LoginException;
import ua.minecraftserversite.repository.UserRepository;

@Service
public class UserService {
    private static UserService service;
    
    private UserService(){}
    
    public static UserService getInstance(){
        if (service == null)
            service = new UserService();
        return service;
    }
    public User login(String name, String password) throws LoginException {
        User user = UserRepository.getInstance().getUser(name,password);
        if (user == null){
            throw new LoginException("Wrong name or password");
        }
        return user;
    }
}
