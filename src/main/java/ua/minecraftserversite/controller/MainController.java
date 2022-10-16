package ua.minecraftserversite.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import ua.minecraftserversite.entity.History;
import ua.minecraftserversite.entity.News;
import ua.minecraftserversite.entity.Permission;
import ua.minecraftserversite.entity.User;
import ua.minecraftserversite.exception.LoginException;
import ua.minecraftserversite.service.*;

import java.util.List;
@Slf4j
@Controller
@SessionAttributes("user")
public class MainController {
    @GetMapping("/")
    public String index(Model model,
                        @RequestAttribute(value = "cases",required = false) List cases,
                        @RequestAttribute(value = "permissions",required = false) List permissions) {
        cases = CaseService.getInstance().printCase();
        permissions = PermissionService.getInstance().printPermissions();
        model.addAttribute("cases",cases);
        model.addAttribute("permissions",permissions);
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
        List<History> history = HistoryService.getInstance().printHistory(user);
        model.addAttribute("histories",history);
        return "personal-office";
    }

    @PostMapping("/news")
    public String addArticle(
            @ModelAttribute("title") String title,
            @ModelAttribute("text") String text,
            Model model){
        News news = new News(title, text);
        NewsService.getInstance().createNewArticle(news);
        return "redirect:/news";
    }

    @PostMapping ("/login")
    public String loginPost(
            @ModelAttribute("nickname") String name,
            @ModelAttribute("password") String pass,
            @SessionAttribute(value = "user",required = false) User user,
            @RequestAttribute(value = "histories",required = false)List histories,
            Model model) {
        try {
            user = UserService.getInstance().login(name,pass);
            model.addAttribute("user",user);
        } catch (LoginException e){
            return "login";
        }
        return "redirect:/personal-office";
    }
    @GetMapping("/exit")
    public String exit(SessionStatus status,Model model){
        status.setComplete();
        return personalOffice(null,model);
    }
    @GetMapping ("/delete")
    public String deleteNews(@RequestParam("id") long id,Model model){
        NewsService.getInstance().deleteNews(id);
        return "redirect:/news";
    }

    @GetMapping("/buy-permission")
    public String buyPermission(@SessionAttribute(value = "user",required = false) User user,
                                @RequestParam("id") long id,
                                @RequestAttribute(value = "bperm",required = false) Permission bperm,
                      Model model) {
        if (user==null)
            return "redirect:/";
        Permission permission = PermissionService.getInstance().getPermission(id);
        model.addAttribute("bperm",permission);
        return "buy-page";
    }
    @GetMapping("/buy-case")
    public String buyCase(@SessionAttribute(value = "user",required = false) User user,
                      @RequestParam("id") long id,
                      Model model) {
        if (user==null)
            return "redirect:/";

        return "buy-page";
    }
}
