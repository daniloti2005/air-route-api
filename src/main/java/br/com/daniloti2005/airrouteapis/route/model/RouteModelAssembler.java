package br.com.daniloti2005.airrouteapis.route.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import br.com.daniloti2005.airrouteapis.route.controller.RouteController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public
class RouteModelAssembler implements RepresentationModelAssembler<Route, EntityModel<Route>> {

    @Override
    public EntityModel<Route> toModel(Route route) {

        return EntityModel.of(route, //
                linkTo(methodOn(RouteController.class).one(route.getId())).withSelfRel(),
                linkTo(methodOn(RouteController.class).all()).withRel("route"));
    }
}
