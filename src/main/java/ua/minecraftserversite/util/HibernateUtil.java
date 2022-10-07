package ua.minecraftserversite.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Value;

import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    @Value("${hibernate.connection.url}")
    private static String JDBC_URL;
    @Value("${hibernate.connection.username}")
    private static String DB_USER;
    @Value("${hibernate.connection.password}")
    private static String DB_PASSWORD;
    @Value("${hibernate.connection.driver_class}")
    private static String DB_DRIVER;
    @Value("${hibernate.dialect}")
    private static String DB_DIALECT;
    @Value("${hibernate.format_sql}")
    private static String DB_CONF_SHOW_SQL;
    @Value("${hibernate.current_session_context_class}")
    private static String DB_CONF_CURR_SES_CON_CLASS;
    @Value("${hibernate.ddl-auto}")
    private static String DB_CONF_HB2DDL_AUTO;
    private HibernateUtil(){}

    private static SessionFactory buildSessionFactory(){
        SessionFactory sessionFactory = null;
        try {
            Configuration configuration = new Configuration();
            Properties settings = new Properties();
            settings.put(DRIVER, DB_DRIVER);
            settings.put(URL, JDBC_URL);
            settings.put(USER, DB_USER);
            settings.put(PASS, DB_PASSWORD);
            settings.put(DIALECT, DB_DIALECT);
            settings.put(SHOW_SQL, DB_CONF_SHOW_SQL);
            settings.put(CURRENT_SESSION_CONTEXT_CLASS, DB_CONF_CURR_SES_CON_CLASS);
            settings.put(HBM2DDL_AUTO, DB_CONF_HB2DDL_AUTO);
            configuration.setProperties(settings);

            //configuration.addAnnotatedClass(Student.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}