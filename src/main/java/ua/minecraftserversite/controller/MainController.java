package ua.minecraftserversite.controller;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.minecraftserversite.entity.User;
import ua.minecraftserversite.util.HibernateUtil;

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
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();
        Query query=session.createQuery("from user where name=:name and password=:password");
        query.setParameter("name", name);
        query.setParameter("password", pass);
        user = (User)query.uniqueResult();
        if (user == null){
            System.out.println("wrong data");
            return "login";
        } else {
            //user = new User(name);
            model.addAttribute("user",user);
        }
        return "personal-office";
    }
    @GetMapping("/exit")
    public String exit(SessionStatus status){
        status.setComplete();
        return "index";
    }
}
