package ua.minecraftserversite.service;

import org.springframework.stereotype.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ua.minecraftserversite.entity.News;
import ua.minecraftserversite.util.HibernateUtil;

@Service
public class NewsService {
    private static NewsService service;

    private NewsService(){}

    public static NewsService getInstance(){
        if (service == null)
            service = new NewsService();
        return service;
    }

}
