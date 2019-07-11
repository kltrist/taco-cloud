package by.grsu.edu.web;

import by.grsu.edu.controller.DesignTacosController;
import by.grsu.edu.entity.Taco;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class TacoResourceAssembler
        extends ResourceAssemblerSupport<Taco, TacoResource> {
    public TacoResourceAssembler() {
        super(DesignTacosController.class, TacoResource.class);
    }

    @Override
    protected TacoResource instantiateResource(Taco taco) {
        return new TacoResource(taco);
    }

    @Override
    public TacoResource toResource(Taco taco) {

        return createResourceWithId(taco.getId(), taco);
    }

    @Bean
    public ResourceProcessor<PagedResources<Resource<Taco>>>
    tacoProcessor(EntityLinks links) {
        return resource -> {
            resource.add(
                    links.linkFor(Taco.class)
                            .slash("recent")
                            .withRel("recents"));
            return resource;
        };
    }

}