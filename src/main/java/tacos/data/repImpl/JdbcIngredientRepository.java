package tacos.data.repImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tacos.data.repositories.IngredientRepository;
import tacos.entity.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbc.query("select id,name,type from Ingredient ",
                this::mapRowToIngredient );

    }

    @Override
    public Ingredient findOne(String id) {
        return jdbc.queryForObject("select id,name,type from Ingredient where id=?",
                this::mapRowToIngredient,id);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
         jdbc.update("INSERT into Ingredient (id,name,type) values(?,?,?)",ingredient.getId(),ingredient.getName(),ingredient.getType());
         return ingredient;
    }


    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum)
            throws SQLException {
        return new Ingredient(
                rs.getString("id"),
                rs.getString("name"),
                Ingredient.Type.valueOf(rs.getString("type")));

    }
}