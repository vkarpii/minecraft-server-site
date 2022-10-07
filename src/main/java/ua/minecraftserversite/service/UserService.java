package ua.minecraftserversite.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ua.minecraftserversite.entity.User;
import ua.minecraftserversite.util.HibernateUtil;

@Service
public class UserService {
    private static UserService service;
    
    private UserService(){}
    
    public static UserService getInstance(){
        if (service == null)
            service = new UserService();
        return service;
    }
    
    public User getUser(String name, String password){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();
        Query query=session.createQuery("from user where name=:name and password=:password");
        query.setParameter("name", name);
        query.setParameter("password", password);
        User user = (User)query.uniqueResult();
        return user;
    }
}
