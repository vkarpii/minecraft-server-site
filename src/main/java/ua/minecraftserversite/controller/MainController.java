package ua.minecraftserversite.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import ua.minecraftserversite.entity.*;
import ua.minecraftserversite.exception.LoginException;
import ua.minecraftserversite.service.*;

import java.util.List;
@Slf4j
@Controller
@RequiredArgsConstructor
@SessionAttributes("user")
public class MainController {

    private final CaseService caseService;
    private final PermissionService permissionService;
    private final UserService userService;
    private final HistoryService historyService;
    private final NewsService newsService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestAttribute(value = "cases",required = false) List cases,
                        @RequestAttribute(value = "permissions",required = false) List permissions) {
        cases = caseService.printCase();
        permissions = permissionService.printPermissions();
        model.addAttribute("cases",cases);
        model.addAttribute("permissions",permissions);
        return "index";
    }

    @GetMapping("/news")
    public String news(Model model, @RequestAttribute(value = "news",required = false) List<News> news) {
        news = newsService.printNews();
        model.addAttribute("news",news);
        return "news";
    }

    @GetMapping("/personal-office")
    public String personalOffice(@SessionAttribute(value = "user",required = false) User user, Model model) {
        if (user==null)
            return "login";
        List<History> history = historyService.printHistory(user);
        model.addAttribute("histories",history);
        return "personal-office";
    }

    @PostMapping("/news")
    public String addArticle(
            @ModelAttribute("title") String title,
            @ModelAttribute("text") String text,
            Model model){
        News news = News.builder()
                .title(title)
                .text(text)
                .build();
        newsService.createNewArticle(news);
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
            user = userService.login(name,pass);
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
        newsService.deleteNews(id);
        return "redirect:/news";
    }

    @GetMapping(value = "/buy/{name}/{id}")
    public String buyPermission(@SessionAttribute(value = "user",required = false) User user,
                                @PathVariable(value = "name", required = false) String name,
                                @PathVariable(value = "id", required = false) int id,
                                @RequestAttribute(value = "buy",required = false) Buying buy,
                      Model model) {
        if (user==null)
            return "redirect:/";
        Buying buying = null;
        if (name.equalsIgnoreCase("privilege")){
            buying = permissionService.getPermission(id);
        } else {
            buying = caseService.getCase(id);
        }
        model.addAttribute("buy",buying);
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
