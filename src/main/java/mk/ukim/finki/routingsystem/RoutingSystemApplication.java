package mk.ukim.finki.routingsystem;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * Spring Boot entry point for the Routing System application.
 */

@SpringBootApplication
@ConfigurationPropertiesScan
public class RoutingSystemApplication {

  public static void main(String[] args) {
    SpringApplication.run(RoutingSystemApplication.class, args);
  }

}
