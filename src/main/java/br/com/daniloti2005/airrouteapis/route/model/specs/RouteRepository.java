package br.com.daniloti2005.airrouteapis.route.model.specs;

import br.com.daniloti2005.airrouteapis.route.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {

}