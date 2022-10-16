package ua.minecraftserversite.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import ua.minecraftserversite.entity.News;
import ua.minecraftserversite.entity.User;
import ua.minecraftserversite.exception.LoginException;
import ua.minecraftserversite.service.NewsService;
import ua.minecraftserversite.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("user")
public class MainController {
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/news")
    public String news(Model model, @RequestAttribute(value = "news",required = false) List<News> news) {
        news = NewsService.getInstance().printNews();
        model.addAttribute("news",news);
        return "news";
    }

    @GetMapping("/personal-office")
    public String personalOffice(@SessionAttribute(value = "user",required = false) User user, Model model) {
        if (user==null)
            return "login";
        return "personal-office";
    }

    @PostMapping("/news")
    public String addArticle(
            @ModelAttribute("title") String title,
            @ModelAttribute("text") String text,
            Model model){
        News news = new News(title, text);
        NewsService.getInstance().createNewArticle(news);
        return "index";
    }

    @PostMapping ("/loginPOST")
    public String loginPost(
            @ModelAttribute("nickname") String name,
            @ModelAttribute("password") String pass,
            @SessionAttribute(value = "user",required = false) User user,
            Model model) {
        try {
            user = UserService.getInstance().login(name,pass);
            model.addAttribute("user",user);
        } catch (LoginException e){
            return "login";
        }
        return "personal-office";
    }
    @GetMapping("/exit")
    public String exit(SessionStatus status){
        status.setComplete();
        return "index";
    }
}
