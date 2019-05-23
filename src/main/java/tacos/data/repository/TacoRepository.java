package tacos.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tacos.entity.Taco;

@Repository
public interface TacoRepository extends CrudRepository<Taco,Long> {

}
