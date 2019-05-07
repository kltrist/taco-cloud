package tacos.data.repository;

import org.springframework.data.repository.CrudRepository;
import tacos.entity.User;

public interface UserRepository extends CrudRepository<User,String> {
    User findByUsername(String username);
}
