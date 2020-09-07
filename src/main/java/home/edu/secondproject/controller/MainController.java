package home.edu.secondproject.controller;
import home.edu.secondproject.model.User;
import home.edu.secondproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String welcomePage(){ ;
        return "welcome";
    }

    @GetMapping("/users")
    public String testPage(Model model){
        List<User> users = userService.allUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/add")
    public String addNewUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "createpage";
    }

    @PostMapping("/save")
    public String saveNewUser(@ModelAttribute("user") User user){
        userService.addNewUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editPage(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("editpage");
        User user = userService.getById(id);
        mav.addObject("user", user);
        return mav;
    }

    @GetMapping("/delete/{id}")
    public String deletePage(@PathVariable Long id){
        userService.deleteById(id);
        return "redirect:/";
    }

}
