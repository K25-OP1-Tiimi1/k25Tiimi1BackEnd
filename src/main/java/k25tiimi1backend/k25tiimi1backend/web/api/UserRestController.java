package k25tiimi1backend.k25tiimi1backend.web.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import k25tiimi1backend.k25tiimi1backend.domain.User;
import k25tiimi1backend.k25tiimi1backend.domain.UserRepository;

@RestController
//@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge=3600)
public class UserRestController {


    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id){
        return userRepository.findById(id);
    }

    @PostMapping("/registerUser")
    public User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }
    
    @DeleteMapping("/user/{id}")
    public Iterable<User> deleteuser(@PathVariable("id") long id) {
        userRepository.deleteById(id);
        return userRepository.findAll();
    }

}
