package k25tiimi1backend.k25tiimi1backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import k25tiimi1backend.k25tiimi1backend.domain.User;
import k25tiimi1backend.k25tiimi1backend.domain.UserRepository;

@Controller
public class UserController {
    
     @Autowired
    private UserRepository userRepository;

    @GetMapping("/userlist")
    public String userList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "userlist";
    }

    @GetMapping("/adduser")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "adduser";
    }

    @PostMapping("/saveuser")
    public String saveUser(User user) {
        userRepository.save(user);
        return "redirect:/userlist";
    }

}
