package tacos.data.repositories;

import org.springframework.data.repository.CrudRepository;
import tacos.entity.Taco;

import java.util.List;

public interface TacoRepository extends CrudRepository<Taco,Long> {
       List<Taco> findTacoByNameNotContainsOrderById(String nameNotContains);
}
