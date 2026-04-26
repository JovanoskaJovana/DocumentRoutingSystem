package mk.ukim.finki.routingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Spring Boot entry point for the Routing System application.
 */

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableAsync
public class RoutingSystemApplication {

  public static void main(String[] args) {
    SpringApplication.run(RoutingSystemApplication.class, args);
  }

}
