package hu.nye.progkorny.autoskartyak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("hu.nye")

public class AutoskartyakApplication {
  public static void main(final String[] args) {
    SpringApplication.run(AutoskartyakApplication.class, args);
  }
}
