package io.pivotal.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  private final GreetingService greetingService;

  public HelloController(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  @RequestMapping("/")
  public String hello() {
    return String.format("%s World!", greetingService.getGreeting());
  }

}
