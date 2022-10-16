package ua.minecraftserversite.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.minecraftserversite.entity.History;
import ua.minecraftserversite.entity.Permission;
import ua.minecraftserversite.entity.User;
import ua.minecraftserversite.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class HistoryRepository {
    private static HistoryRepository repository;
    private HistoryRepository(){}
    public static HistoryRepository getInstance(){
        if (repository == null)
            repository = new HistoryRepository();
        return repository;
    }

    public List<History> getHistory(User user) {
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from History where user.id=:id");
        query.setParameter("id", user.getId());
        List<History> histories = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return histories;
    }
}
