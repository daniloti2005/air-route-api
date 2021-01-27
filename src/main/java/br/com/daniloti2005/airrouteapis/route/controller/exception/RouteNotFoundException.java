package br.com.daniloti2005.airrouteapis.route.controller.exception;

public class RouteNotFoundException extends RuntimeException {

  public RouteNotFoundException(Long id) {
    super("Could not find employee " + id);
  }
}