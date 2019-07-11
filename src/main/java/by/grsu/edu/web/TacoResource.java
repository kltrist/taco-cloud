package by.grsu.edu.web;

import by.grsu.edu.entity.Ingredient;
import by.grsu.edu.entity.Taco;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;
import java.util.List;

public class TacoResource extends ResourceSupport {
    @Getter
    private final String name;
    @Getter
    private final Date createdAt;
    @Getter
    private final List<Ingredient> ingredients;

    public TacoResource(Taco taco) {
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients = taco.getIngredients();
    }
}