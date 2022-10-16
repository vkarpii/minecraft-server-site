package ua.minecraftserversite.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ua.minecraftserversite.entity.News;
import ua.minecraftserversite.entity.User;
import ua.minecraftserversite.util.HibernateUtil;

import java.util.List;

@Repository
public class NewsRepository {
    private static NewsRepository repository;
    private NewsRepository(){}
    public static NewsRepository getInstance(){
        if (repository == null)
            repository = new NewsRepository();
        return repository;
    }
    public News getNews(String title, String text){
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from News where title=:title and text=:text");
        query.setParameter("title", title);
        query.setParameter("text", text);
        News news = (News) query.uniqueResult();
        session.getTransaction().commit();
        return news;
    }

    public List<News> getAllNews(){
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from News");
        List<News> news = query.getResultList();
        session.getTransaction().commit();
        return news;
    }
    public boolean addNews(News news){
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.save(news);
        session.getTransaction().commit();
        return true;
    }

}
