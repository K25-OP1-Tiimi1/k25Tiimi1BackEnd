package k25tiimi1backend.k25tiimi1backend.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

 public User findByEmail(String email); 
}
