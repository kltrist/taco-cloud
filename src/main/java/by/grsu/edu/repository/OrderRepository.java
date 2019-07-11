package by.grsu.edu.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import by.grsu.edu.entity.Order;
import by.grsu.edu.entity.User;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {
     List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
