package ua.minecraftserversite.service;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.stereotype.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ua.minecraftserversite.entity.News;
import ua.minecraftserversite.repository.NewsRepository;
import ua.minecraftserversite.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {
    private static NewsService service;

    private NewsService(){}

    public static NewsService getInstance(){
        if (service == null)
            service = new NewsService();
        return service;
    }
    public List<News> printNews(){
        List<News> news = NewsRepository.getInstance().getAllNews();
        return news;
    }

    public boolean createNewArticle(News news){
        NewsRepository.getInstance().addNews(news);
        return true;
    }

    public boolean deleteNews(long id){
        NewsRepository.getInstance().deleteNews(id);
        return true;
    }
}
