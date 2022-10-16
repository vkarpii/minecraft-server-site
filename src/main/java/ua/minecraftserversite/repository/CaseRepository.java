package ua.minecraftserversite.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.minecraftserversite.entity.Case;
import ua.minecraftserversite.util.HibernateUtil;

import java.util.List;

public class CaseRepository {
    private static CaseRepository repository;
    private CaseRepository(){}
    public static CaseRepository getInstance(){
        if (repository == null)
            repository = new CaseRepository();
        return repository;
    }

    public List<Case> getAllCases() {
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        Query query= session.createQuery("from  Case");
        List<Case> cases = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return cases;
    }
}
