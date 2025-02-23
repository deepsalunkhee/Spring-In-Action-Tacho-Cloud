package tacho.data;

import org.springframework.data.repository.CrudRepository;

import tacho.models.User;


public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

}
