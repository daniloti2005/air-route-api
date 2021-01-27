package br.com.daniloti2005.airrouteapis.route.controller.advice;

import br.com.daniloti2005.airrouteapis.route.controller.exception.RouteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class RouteNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(RouteNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String employeeNotFoundHandler(RouteNotFoundException ex) {
    return ex.getMessage();
  }
}