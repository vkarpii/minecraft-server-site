package ua.minecraftserversite.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ua.minecraftserversite.entity.News;
import ua.minecraftserversite.repository.NewsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final NewsRepository repository;

    public List<News> printNews(){
        return repository.findAll();
    }

    public boolean createNewArticle(News news){
        repository.save(news);
        return true;
    }

    public boolean deleteNews(long id){
        repository.deleteById(id);
        return true;
    }
}
