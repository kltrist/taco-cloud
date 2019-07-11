package by.grsu.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import by.grsu.edu.entity.Taco;

@Repository
public interface TacoRepository extends JpaRepository<Taco,Long> {

}
