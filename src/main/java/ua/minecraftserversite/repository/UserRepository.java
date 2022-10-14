package ua.minecraftserversite.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ua.minecraftserversite.entity.User;
import ua.minecraftserversite.util.HibernateUtil;

@Repository
public class UserRepository {
    private static UserRepository repository;
    private UserRepository(){}
    public static UserRepository getInstance(){
        if (repository == null)
            repository = new UserRepository();
        return repository;
    }
    public User getUser(String name, String password){
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from User where nickname=:nickname and password=:password");
        query.setParameter("nickname", name);
        query.setParameter("password", password);
        User user = (User) query.uniqueResult();
        session.getTransaction().commit();
        return user;
    }
}
