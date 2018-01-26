package io.pivotal.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloSpringBootApplication {

  private final Logger logger = LoggerFactory.getLogger(HelloSpringBootApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(HelloSpringBootApplication.class, args);
  }

  @Bean
  CommandLineRunner loadDatabase(GreetingRepository repository) {
    return args -> {
      logger.debug("loading database..");
      repository.save(new Greeting(1L, "Hello"));
      repository.save(new Greeting(2L, "Hola"));
      repository.save(new Greeting(3L, "Ohai"));
      logger.debug("record count: {}", repository.count());
      repository.findAll().forEach(x -> logger.debug(x.toString()));
    };
  }

}
