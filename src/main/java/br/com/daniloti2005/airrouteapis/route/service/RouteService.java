package br.com.daniloti2005.airrouteapis.route.service;

import br.com.daniloti2005.air_route_commons.interpreter.dijkstra.DijkstraAlgorithm;
import br.com.daniloti2005.air_route_commons.interpreter.dijkstra.Edge;
import br.com.daniloti2005.air_route_commons.interpreter.dijkstra.Node;
import br.com.daniloti2005.air_route_commons.interpreter.dijkstra.Route;
import br.com.daniloti2005.air_route_commons.service.csv.FileService;
import br.com.daniloti2005.airrouteapis.route.model.RouteModelAssembler;
import br.com.daniloti2005.airrouteapis.route.model.specs.RouteRepository;
import org.springframework.hateoas.EntityModel;


import java.util.List;
import java.util.stream.Collectors;

public class RouteService {
    private Route route;
    private List<Node> results;

    public RouteService() {
    }

    public RouteService(Route route) {
        this.route = route;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public List<Node> getResults() {
        return results;
    }

    public void setResults(List<Node> results) {
        this.results = results;
    }

    public List<Node> performDijkstra(){
        List<Node> ret = null;

        return ret;

    }

    public List<Node> run(String beginning, String ending, Route route) {

        DijkstraAlgorithm.initialization(route.getNodeFromMap(beginning),
                route.getNodeFromMap(ending),
                route);

        List<Node> result = DijkstraAlgorithm.perform();

        return result;

    }
}
