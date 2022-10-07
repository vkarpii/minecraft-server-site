package ua.minecraftserversite.util;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;
import ua.minecraftserversite.entity.News;
import ua.minecraftserversite.entity.Permission;
import ua.minecraftserversite.entity.Role;
import ua.minecraftserversite.entity.User;

import java.io.InputStream;
import java.util.Properties;


@Slf4j
@Component
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private static final String PROPERTIES_NAME = "hibernate.properties";

    private HibernateUtil(){}

    private static SessionFactory buildSessionFactory(){
        SessionFactory sessionFactory = null;
        try {
            Properties properties = new Properties();
            InputStream inputStream = HibernateUtil.class
                    .getClassLoader()
                    .getResourceAsStream(PROPERTIES_NAME);
            properties.load(inputStream);
            Configuration configuration = new Configuration();
            configuration.setProperties(properties);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Permission.class);
            configuration.addAnnotatedClass(Role.class);
            configuration.addAnnotatedClass(News.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null)
            sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}