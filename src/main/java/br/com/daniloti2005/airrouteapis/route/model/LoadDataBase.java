package br.com.daniloti2005.airrouteapis.route.model;


import br.com.daniloti2005.airrouteapis.route.model.specs.RouteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(RouteRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Route("GRU","BRC",10)));
            log.info("Preloading " + repository.save(new Route("BRC","SCL",5)));
            log.info("Preloading " + repository.save(new Route("GRU","CDG",75)));
            log.info("Preloading " + repository.save(new Route("GRU","SCL",20)));
            log.info("Preloading " + repository.save(new Route("GRU","ORL",56)));
            log.info("Preloading " + repository.save(new Route("ORL","CDG",5)));
            log.info("Preloading " + repository.save(new Route("SCL","ORL",20)));

        };
    }
}
