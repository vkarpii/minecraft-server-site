package ua.minecraftserversite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.minecraftserversite.entity.User;

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

    @PostMapping ("/loginPOST")
    public String loginPost(
            @ModelAttribute("nickname") String name,
            @ModelAttribute("password") String pass,
            @SessionAttribute(value = "user",required = false) User user,
            Model model) {
        user = new User(name);
        model.addAttribute("user",user);
        return "personal-office";
    }
    @GetMapping("/exit")
    public String exit(SessionStatus status){
        status.setComplete();
        return "index";
    }
}
