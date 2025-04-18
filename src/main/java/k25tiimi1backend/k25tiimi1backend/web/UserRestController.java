package k25tiimi1backend.k25tiimi1backend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import k25tiimi1backend.k25tiimi1backend.domain.User;
import k25tiimi1backend.k25tiimi1backend.domain.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserRestController {


    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

}
