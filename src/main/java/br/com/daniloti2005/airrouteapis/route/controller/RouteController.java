package br.com.daniloti2005.airrouteapis.route.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.daniloti2005.air_route_commons.interpreter.dijkstra.Node;
import br.com.daniloti2005.airrouteapis.route.controller.exception.RouteNotFoundException;
import br.com.daniloti2005.airrouteapis.route.model.DijkstraParameters;
import br.com.daniloti2005.airrouteapis.route.model.DijkstraResult;
import br.com.daniloti2005.airrouteapis.route.model.Route;
import br.com.daniloti2005.airrouteapis.route.model.RouteModelAssembler;
import br.com.daniloti2005.airrouteapis.route.model.specs.RouteRepository;
import br.com.daniloti2005.airrouteapis.route.service.RouteService;
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

    @PostMapping("/dijkstra")
    List<DijkstraResult> runRoute(@RequestBody DijkstraParameters parameter) {
        RouteService service = new RouteService();
        br.com.daniloti2005.air_route_commons.interpreter.dijkstra.Route rota = new br.com.daniloti2005.air_route_commons.interpreter.dijkstra.Route();
        for (Route item : repository.findAll()){
            rota.makeRoute(item.getOrigin(), item.getDestination(), item.getCost());
        }
        List<Node> result = service.run(parameter.getOrigin(), parameter.getDestination(), rota);

        List<DijkstraResult> listReturn = new ArrayList<>();

        for (Node item : result) {
            DijkstraResult res = new DijkstraResult();
            res.setNode(item.getName());
            res.setDistanceFromOrigin(item.getDistanceFromOrigin());
            res.setDistanceFromPrevious(item.getDistanceFromPrevious());
            listReturn.add(res);
        }
        return listReturn;
    }

    @GetMapping("/routes")
    public CollectionModel<EntityModel<Route>> all() {

        List<EntityModel<Route>> routes = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(routes, linkTo(methodOn(RouteController.class).all()).withSelfRel());
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
                .map(route -> {
                    route.setOrigin(newRoute.getOrigin());
                    route.setDestination(newRoute.getDestination());
                    route.setCost(newRoute.getCost());
                    return repository.save(route);
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
