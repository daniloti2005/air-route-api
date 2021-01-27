package br.com.daniloti2005.airrouteapis.route.controller;

import java.util.List;
import java.util.stream.Collectors;

import br.com.daniloti2005.airrouteapis.route.controller.exception.RouteNotFoundException;
import br.com.daniloti2005.airrouteapis.route.model.Route;
import br.com.daniloti2005.airrouteapis.route.model.RouteModelAssembler;
import br.com.daniloti2005.airrouteapis.route.model.specs.RouteRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class RouteController {

    private final RouteRepository repository;

    private final RouteModelAssembler assembler;

    RouteController(RouteRepository repository, RouteModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }


    @GetMapping("/routes")
    public CollectionModel<EntityModel<Route>> all() {

        List<EntityModel<Route>> employees = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(employees, linkTo(methodOn(RouteController.class).all()).withSelfRel());
    }

    @PostMapping("/route")
    Route newRoute(@RequestBody Route newRoute) {
        return repository.save(newRoute);
    }

    // Single item

    @GetMapping("/route/{id}")
    public EntityModel<Route> one(@PathVariable Long id) {

        Route route = repository.findById(id) //
                .orElseThrow(() -> new RouteNotFoundException(id));

        return assembler.toModel(route);
    }

    @PutMapping("/route/{id}")
    Route replaceEmployee(@RequestBody Route newRoute, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setOrigin(newRoute.getOrigin());
                    employee.setDestination(newRoute.getDestination());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newRoute.setId(id);
                    return repository.save(newRoute);
                });
    }

    @DeleteMapping("/route/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }


}
