package ua.minecraftserversite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import ua.minecraftserversite.entity.News;
import ua.minecraftserversite.entity.User;
import ua.minecraftserversite.exception.LoginException;
import ua.minecraftserversite.service.UserService;

@Controller
@SessionAttributes("user")
public class MainController {
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/news")
    public String news(Model model) {
        return "news";
    }

    @GetMapping("/personal-office")
    public String personalOffice(@SessionAttribute(value = "user",required = false) User user, Model model) {
        if (user == null){
            return "login";
        }
        return "personal-office";
    }

    @PostMapping("/news")
    public String addArticle(
            @ModelAttribute("title") String title,
            @ModelAttribute("text") String full_text,
            Model model){
        News news = new News(title, full_text);
        return "";
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
