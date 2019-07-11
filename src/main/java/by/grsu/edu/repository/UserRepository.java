package by.grsu.edu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import by.grsu.edu.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
}
