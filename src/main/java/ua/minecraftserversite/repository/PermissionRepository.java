package ua.minecraftserversite.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.minecraftserversite.entity.Permission;
import ua.minecraftserversite.util.HibernateUtil;

import java.util.List;

public class PermissionRepository {
    private static PermissionRepository repository;
    private PermissionRepository(){}
    public static PermissionRepository getInstance(){
        if (repository == null)
            repository = new PermissionRepository();
        return repository;
    }

    public List<Permission> getAllPermissions() {
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from Permission");
        List<Permission> permissions = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return permissions;
    }
}
