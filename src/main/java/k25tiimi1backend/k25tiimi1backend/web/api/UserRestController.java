package k25tiimi1backend.k25tiimi1backend.web.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import k25tiimi1backend.k25tiimi1backend.domain.User;
import k25tiimi1backend.k25tiimi1backend.domain.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id);
    }


    @GetMapping("/user/findemail/{email}/{password}")
    public User getUserBySignIn(@PathVariable("email") String email,@PathVariable("password") String password) {
        User user = userRepository.findByEmail(email);
            if (user.getPassword().equals(password)){
                return user;}
     
                else {return user;}
    }

    @PostMapping("/registerUser")
    public ResponseEntity<?> newUser(@RequestBody User newUser) {
    User existingUser = userRepository.findByEmail(newUser.getEmail());
    if (existingUser != null) {
        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body("Sähköpostiosoite on jo käytössä.");
    }

    User savedUser = userRepository.save(newUser);
    return ResponseEntity.ok(savedUser);
}

    @DeleteMapping("/user/{id}")
    public Iterable<User> deleteuser(@PathVariable("id") long id) {
        userRepository.deleteById(id);
        return userRepository.findAll();
    }

}
