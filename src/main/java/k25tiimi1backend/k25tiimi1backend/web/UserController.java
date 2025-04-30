package k25tiimi1backend.k25tiimi1backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/edituser/{id}")
    public String editUserForm(@PathVariable("id") Long userId, Model model) {
    User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + userId));
    model.addAttribute("user", user);
    return "edituser";
}

@PostMapping("/updateuser/{id}")
public String updateUser(@PathVariable("id") Long userId, User updatedUser) {
    User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + userId));
    user.setEmail(updatedUser.getEmail());
    user.setFirstname(updatedUser.getFirstname());
    user.setLastname(updatedUser.getLastname());
    user.setPassword(updatedUser.getPassword());
    userRepository.save(user);
    return "redirect:/userlist";
}

@GetMapping("/deleteuser/{id}")
public String deleteUser(@PathVariable("id") Long userId) {
    userRepository.deleteById(userId);
    return "redirect:/userlist";
}

    @PostMapping("/saveuser")
    public String saveUser(User user) {
        userRepository.save(user);
        return "redirect:/userlist";
    }

}
